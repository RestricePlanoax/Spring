package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.HelloBean;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext c = new ClassPathXmlApplicationContext("com/vishnu/resources/app.xml");
	
		//default scope
	 System.out.println(c.getBean("hi"));
	 System.out.println(c.getBean("hi"));
	 
	 
     //prototype scope 
	 System.out.println(c.getBean("hello"));
	 System.out.println(c.getBean("hello"));

	}

}
