package com.vishnu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.beans.HelloBean;
import com.vishnu.beans.ThreadScope;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext c = new ClassPathXmlApplicationContext("com/vishnu/resources/app.xml");
		
		HelloBean hb1 = (HelloBean) c.getBean("hello");
		System.out.println(hb1);
		ThreadScope t = (ThreadScope) c.getBean("threadScope");
		HelloBean hb2 = (HelloBean) t.remove("hello");
		System.out.println(hb2);
        System.out.println(hb1==hb2);
        
        
        HelloBean hb3 = (HelloBean) c.getBean("hello");
        HelloBean hb4 = (HelloBean) c.getBean("hello");
        System.out.println("MAIN THREAD----->" + hb3);
        System.out.println("MAIN THREAD----->" + hb4);
        
        //creating an anonymous class
        
        Runnable r = new Runnable() {
        	
        	@Override
        	public void run() {
        		HelloBean hb5 = (HelloBean) c.getBean("hello");
        		HelloBean hb6 = (HelloBean) c.getBean("hello");
        		
        		System.out.println("Anon class Thread----> "+ hb5);
        		System.out.println("Anon class Thread----> "+ hb6);
        	}
        };
        
        Thread thread= new Thread(r);
        thread.start();
        
        //using lambda expressions
        new Thread(() -> {
        	HelloBean hb7 = (HelloBean) c.getBean("hello");
        	HelloBean hb8 = (HelloBean) c.getBean("hello");
        	
        	System.out.println("Lambda expr class Thread----> "+ hb7);
    		System.out.println("Lambda  expr class Thread----> "+ hb8);
        	
        	
        }).start();
        
        
 

}
}