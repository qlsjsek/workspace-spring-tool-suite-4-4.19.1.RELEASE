package com.itwill.user.dao.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootUserDaoImplMyBatisMain {
	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootUserDaoImplMyBatisMain.class, args);
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		 UserDao userDao= (UserDao)applicationContext.getBean(UserDao.class);
		 System.out.println(userDao.findUserList());
		//System.out.println(userDao.create(new User("ccc","ccc","ccc","ccc")));
		 System.out.println(userDao.findUser("ccc"));
		 
		
		User user=applicationContext.getBean(User.class);
		System.out.println(user);
	}

}
