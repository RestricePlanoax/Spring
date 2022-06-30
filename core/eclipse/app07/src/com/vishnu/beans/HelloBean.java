package com.vishnu.beans;

public class HelloBean {
   private String name;
   
   static {
	   System.out.println("Class Loading");
   }
   public HelloBean(){
	   System.out.println("Object Instantiation");
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   
}
