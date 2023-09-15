package com.itwill.guest.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class SpringBootGuestDaoApplication {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootGuestDaoApplication.class, args);
		GuestDao guestDao=applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao.selectAll());
		
	}

}
