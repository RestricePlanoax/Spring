package com.vishnu.beans;

public class HelloBean {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String sayHello()
	{
		return "Hey" + " " + name + " THIS IS USING SETTER METHOD";
	}

}
