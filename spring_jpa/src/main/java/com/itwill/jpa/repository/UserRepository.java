package com.itwill.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	List<User> findByName(String name);
	List<User> getByName(String name);
	List<User> readByName(String name);
	List<User> searchByName(String name);

	List<User> findByEmail(String email);
	List<User> findByNameAndEmail(String name,String email);
	List<User> findByNameOrEmail(String name,String email);

	List<User> findFirst2ByName(String name);
	List<User> findTop2ByName(String name);

	List<User> findByNameContains(String name);
	List<User> findByNameStartingWith(String name);
	List<User> findByNameEndingWith(String name);
	List<User> findByNameLike(String name);

	@Query(value="select * from userinfo where name=?1",nativeQuery = true)
	List<User> findByNameSQL(String name);





}
	