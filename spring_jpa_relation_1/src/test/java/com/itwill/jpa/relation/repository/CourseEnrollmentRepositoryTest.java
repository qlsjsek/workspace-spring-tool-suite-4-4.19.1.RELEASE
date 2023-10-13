package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Address;
import com.itwill.jpa.relation.entity.Course;
import com.itwill.jpa.relation.entity.CourseEnrollment;
import com.itwill.jpa.relation.entity.Student;
import com.itwill.jpa.relation.entity.Tutor;

class CourseEnrollmentRepositoryTest extends SpringJpaApplicationTests{
	@Autowired
	CourseEnrollmentRepository courseEnrollmentRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	@Disabled
	void saveCourseEnrollmentWithStudentAndCourse1() {
		CourseEnrollment courseEnrollment1=CourseEnrollment.builder().build();
		Student student1=Student.builder()
				.name("학생1")
				.email("student1@gmai.com")
				.dob(LocalDateTime.now())
				.phone("111-22222")
			   .build();
		Course course1=Course.builder()
				.name("재미있는 스프링부트")
				.description("개콘보다잼있음")
				.build();
		
		courseEnrollment1.setStudent(student1);
		courseEnrollment1.setCourse(course1);
		courseEnrollmentRepository.save(courseEnrollment1);
		
	}
	@Transactional
	@Rollback(false)
	@Test
	@Disabled
	void saveCourseEnrollmentWithStudentAndCourse2() {
		CourseEnrollment courseEnrollment1=CourseEnrollment.builder().build();
		Student student1=studentRepository.findById(1L).get();
		Course course1=courseRepository.findById(5L).get();
		courseEnrollment1.setStudent(student1);
		courseEnrollment1.setCourse(course1);
		
		courseEnrollmentRepository.save(courseEnrollment1);
	}
	@Test
	//@Disabled
	@Transactional
	void selectCourseEnrollmentWithStudentAndCourse() {
		CourseEnrollment courseEnrollment = courseEnrollmentRepository.findById(1L).get();
		System.out.println("CourseEnrollment:"+courseEnrollment);
		System.out.println("CourseEnrollment-->Student:"+courseEnrollment.getStudent());
		System.out.println("CourseEnrollment-->Course:"+courseEnrollment.getCourse());
	}
	
}
