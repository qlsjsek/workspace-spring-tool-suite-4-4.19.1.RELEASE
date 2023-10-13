package com.itwill.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.entity.User;

class UserRepositoryTest extends SpringJpaApplicationTests{
	@Autowired
	UserRepository userRepository;
	
	//@Test
	void customSelect() {
		System.out.println(">>>findByName				:"+userRepository.findByName("김경호1"));
		System.out.println(">>>findByEmail				:"+userRepository.findByEmail("guard2@gmail.com"));
		System.out.println(">>>findByNameAndEmail		:"+userRepository.findByNameAndEmail("김경호3", "guard3@gmail.com"));
		System.out.println(">>>findByNameOrEmail		:"+userRepository.findByNameOrEmail("김경호3", "guard2@gmail.com"));
		System.out.println(">>>findFirst2ByName			:"+userRepository.findFirst2ByName("김경호11"));
		System.out.println(">>>findTop2ByName			:"+userRepository.findTop2ByName("김경호11"));
		System.out.println(">>>findByNameSQL			:"+userRepository.findByNameSQL("김경호11"));
		System.out.println(">>>findByNameContains		:"+userRepository.findByNameContains("경호").size());
		System.out.println(">>>findByNameStartingWith	:"+userRepository.findByNameStartingWith("김경호11").size());
		System.out.println(">>>findByNameEndingWith		:"+userRepository.findByNameEndingWith("11").size());
		System.out.println(">>>findByNameLike			:"+userRepository.findByNameLike("%"+"경호"+"%").size());
	}
	
	@DisplayName("회원삭제")
	//@Test
	//@Disabled
	@Transactional
	@Rollback(value=false)
	void delete() {
		userRepository.deleteById("guard20");
		
		userRepository.delete(userRepository.findById("guard19").get());
	}
	
	@DisplayName("회원수정")
	//@Test
	//@Disabled
	@Transactional
	@Rollback(value = true)
	void update() {
		User findUser1=userRepository.findById("guard1").get();
		findUser1.setName("제임스");
		findUser1.setEmail("james@gmail.com");
		//userRepository.save(findUser1);
	}
	
	@DisplayName("회원가입")
	//@Test
	//@Disabled
	void testSave() {
		User user1=User.builder()
						.userId("guard21")
						.password("1111")
						.email("guard1@naver.com")
						.name("네임")
							.build();
		User saveUser1=userRepository.save(user1);
		System.out.println(saveUser1);
		User user2=User.builder()
				.userId("guard22")
				.password("2222")
				.email("guard2@naver.com")
				.name("이름")
				.build();
		User saveUser2=userRepository.save(user2);
		System.out.println(saveUser1);
		System.out.println(saveUser2);
	}
	@DisplayName("회원아이디로찾기")
	//@Test
	//@Disabled
	void testFindById() {
		Optional<User> optionalUser=userRepository.findById("guard1");
		if(optionalUser.isPresent()) {
			User findUser1=optionalUser.get();
			System.out.println(findUser1);
		}
	}

}
