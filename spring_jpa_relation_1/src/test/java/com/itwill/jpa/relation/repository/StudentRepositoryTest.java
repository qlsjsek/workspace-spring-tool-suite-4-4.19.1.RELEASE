package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Address;
import com.itwill.jpa.relation.entity.Student;

class StudentRepositoryTest extends SpringJpaApplicationTests {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	AddressRepository addressRepository;
	@Test
	//@Disabled
	void saveStudentWithAddress() {
		Address address=Address.builder()
				.street("강릉호텔")
				.city("강릉")
				.state("강원")
				.zip("343434")
				.country("대한민국")
				.build();
		
		Student student=Student.builder()
						.name("학생1")
						.email("student1@gmai.com")
						.dob(LocalDateTime.now())
						.phone("111-22222")
						.build();
		
		student.setAddress(address);
		studentRepository.save(student);
	
	}
	@Transactional
	@Rollback(false)
	@Test
	//@Disabled
	void selectStudentWithAddress() {
		Student student = studentRepository.findById(1L).get();
		System.out.println("Student:"+student);
		//System.out.println(">> Student:"+studentRepository.findById(1L).get());
		//System.out.println(">> Student --> Address:"+studentRepository.findById(1L).get().getAddress());

	}
}