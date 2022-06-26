package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.HelloBean;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/vishnu/resources/appplicationContext.xml");
		
		HelloBean hello = (HelloBean) context.getBean("hi");
		
		System.out.println(hello.sayHello());

	}

}
