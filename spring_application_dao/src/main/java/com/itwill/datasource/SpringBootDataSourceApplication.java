package com.itwill.datasource;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDataSourceApplication {
	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootDataSourceApplication.class, args);
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		System.out.println("1.DataSource:"+dataSource.toString());
		System.out.println("2.Connection:"+dataSource.getConnection());
		
	}

}
