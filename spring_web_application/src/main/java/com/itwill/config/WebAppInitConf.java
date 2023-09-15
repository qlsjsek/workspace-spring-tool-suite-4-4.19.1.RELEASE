package com.itwill.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
/*
 * web.xml설정을 대신할 클래스
 * -  톰캣실행시 기본설정
 */
public class WebAppInitConf implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
				/**********1.DispatcherServlet등록***************
				AnnotationConfigWebApplicationContext context = 
						new AnnotationConfigWebApplicationContext();
				context.register(WebConfig.class);
				ServletRegistration.Dynamic dynamic=
						servletContext.addServlet("dispatcherSevlet", new DispatcherServlet(context));
				dynamic.setLoadOnStartup(0);
				dynamic.addMapping("/");
				***************************************************/
				
				/********2.config 설정 클래스[ApplicationConfig.java,WebConfig.java]를사용한설정******
				//ApplicationConfig.java
				AnnotationConfigWebApplicationContext applicationContext = 
						new AnnotationConfigWebApplicationContext();
				applicationContext.register(ApplicationConfig.class);
				//Listener등록
				servletContext.addListener(new ContextLoaderListener(applicationContext));
				//WebConfig.java
				AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
				servletConfig.register(WebConfig.class);
				ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
				dispatcherServlet.setLoadOnStartup(1);
				dispatcherServlet.addMapping("/");
				//encodingFilter설정
				FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));
				filterRegistration.addMappingForUrlPatterns(null, true, "/*");
				*/
	}
	
}
