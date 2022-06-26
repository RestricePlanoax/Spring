package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.HelloBeans;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/vishnu/resources/applicationContext.xml");
		
		HelloBeans hello = (HelloBeans)context.getBean("helloBee");
		
		
		System.out.println(hello.sayHello("VISHNU"));

	}

}
