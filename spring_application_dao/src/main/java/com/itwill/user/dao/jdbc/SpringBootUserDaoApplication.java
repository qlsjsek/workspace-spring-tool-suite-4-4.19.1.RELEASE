package com.itwill.user.dao.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootUserDaoApplication {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootUserDaoApplication.class, args);
		UserDao userDao=applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());
	}

}
