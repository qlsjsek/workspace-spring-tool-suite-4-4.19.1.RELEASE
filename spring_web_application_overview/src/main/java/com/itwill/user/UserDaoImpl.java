package com.itwill.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public List<User> list() {
		List<User> userList=new ArrayList<User>();
		
		User user1=
				User.builder().id(1).name("KIM").build();
		userList.add(user1);
		userList.add(User.builder().id(2).name("LEE").build());
		userList.add(User.builder().id(3).name("CHOI").build());
		
		return userList;
	}

}
