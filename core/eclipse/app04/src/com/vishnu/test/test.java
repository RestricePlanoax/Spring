package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.WishBean;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext c = new ClassPathXmlApplicationContext("com/vishnu/resources/applicationContext.xml");
		
		WishBean w = (WishBean) c.getBean("WishBean");
		
		System.out.println(w.WishUser());
		

	}

}
