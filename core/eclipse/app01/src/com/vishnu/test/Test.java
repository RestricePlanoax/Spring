package com.vishnu.test;
import com.vishnu.beans.HelloBeans;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

ApplicationContext context2 = new ClassPathXmlApplicationContext("com/vishnu/resources/applicationContext.xml");

HelloBeans hello =(HelloBeans)context.getBean("helloBean");

HelloBeans hello2 = (HelloBeans)context2.getBean("helloBean");


System.out.println(hello.sayHello());

System.out.println("Application XML file is not in src folder " + hello2.sayHello());

	}

}
