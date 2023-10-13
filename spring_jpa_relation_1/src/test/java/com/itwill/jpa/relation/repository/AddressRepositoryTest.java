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
import com.itwill.jpa.relation.entity.Student;
import com.itwill.jpa.relation.entity.Tutor;

class AddressRepositoryTest extends SpringJpaApplicationTests{
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	StudentRepository studentRepository;
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void savAddressWithStudents() {
		
		Address address=Address.builder()
				.street("서천호텔")
				.city("서천")
				.state("충청도")
				.zip("343434")
				.country("대한민국")
				.build();
		
		Student student1=Student.builder()
				.name("범석")
				.email("student1@gmai.com")
				.dob(LocalDateTime.now().minusYears(12))
				.phone("111-22222")
			   .build();
		Student student2=Student.builder()
				.name("호진")
				.email("student2@gmai.com")
				.dob(LocalDateTime.now().minusYears(12))
				.phone("333-4444")
				.build();
		address.getStudents().add(student1);
		address.getStudents().add(student2);
		student1.setAddress(address);
		student2.setAddress(address);
		
		addressRepository.save(address);
		
	}
	@Test
	@Disabled
	void savAddressWithTutors() {
		
		Address address=Address.builder()
				.street("강릉호텔")
				.city("강릉")
				.state("강원")
				.zip("343434")
				.country("대한민국")
				.build();
		
		Tutor tutor1=Tutor.builder()
				.name("김강사1")
				.email("kim1@gmail.com")
				.phone("111-1111")
				.dob(LocalDateTime.now())
				.build();
		Tutor tutor2=Tutor.builder()
				.name("김강사2")
				.email("kim2@gmail.com")
				.phone("222-2222")
				.dob(LocalDateTime.now().minusMonths(3))
				.build();
		
		
	}
	@Test
	//@Disabled
	@Transactional
	void selectAddressWithStudents() {
		Address address = addressRepository.findById(9L).get();
		System.out.println("Address:"+address);
		System.out.println("Address->Student:"+address.getStudents());
	}

}
