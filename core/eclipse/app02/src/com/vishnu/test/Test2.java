package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.HelloBean;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/vishnu/resources/appContext.xml");
		
       HelloBean hi = (HelloBean) context.getBean("hi");
       
       hi.setName("VISHNU");
       System.out.println(hi.sayHello());
	}

}
