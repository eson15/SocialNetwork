package com.xiaonei.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiaonei.domain.Country;
import com.xiaonei.service.impl.TestService;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		TestService ts = (TestService) ctx.getBean("testService");
		List<Country> list = ts.showCountry();
		for(Country country : list) {
			System.out.println(country.getName());
		}
	}

}
