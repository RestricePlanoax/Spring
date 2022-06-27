package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.StudentBean;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext c = new ClassPathXmlApplicationContext("com/vishnu/resources/applicationContext.xml");
		
		StudentBean s = (StudentBean) c.getBean("studentBean");
		
		s.getStudentDetails();

	}

}
