package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class SpringApplicationMain {

	public static void main(String[] args) throws Exception {
		/*
		 * Spring Container객체생성 - ApplicationContext[BeanFactory]객체생성
		 */
		/*
		 * 1.Spring Bean설정파일을 읽어서 SpringContainer객체생성
		 */
		System.out.println("--------------ApplicationContext객체생성시작--------------------------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill0/context/0.application_context.xml");
		System.out.println("--------------ApplicationContext객체생성끝---------------------------------");
		
		GuestService guestService=(GuestService)applicationContext.getBean("guestService");
		guestService.selectAll();
		

	}

}
