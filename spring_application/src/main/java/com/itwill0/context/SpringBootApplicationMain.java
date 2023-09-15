package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;
import com.itwill.product.ProductService;

@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.guest")
public class SpringBootApplicationMain {
	public static void main(String[] args) throws Exception {
		System.out.println("-----------ApplicationContext생성시작-----------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootApplicationMain.class, args);
		System.out.println("-----------ApplicationContext끝-----------------");
		GuestService guestService=(GuestService) applicationContext.getBean("guestService");
		System.out.println(guestService.selectAll());
	}

}
