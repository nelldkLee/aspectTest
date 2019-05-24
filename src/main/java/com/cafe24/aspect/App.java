package com.cafe24.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		final String configPath = "config/applicationContext.xml";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(configPath);
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
	}
}
