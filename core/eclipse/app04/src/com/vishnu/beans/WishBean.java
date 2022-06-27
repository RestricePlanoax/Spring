package com.vishnu.beans;

public class WishBean {
  private String name;
  private String wishMessage;
  
  public void setName(String name)
  {
	  this.name = name;
  }
  public void setWishMessage(String message)
  {
	  this.wishMessage = message;
  }
  public String getName()
  {
	  return this.name;
  }
  public String getWishMessage()
  {
	  return this.wishMessage;
  }
  public String WishUser()
  {
	  return "HEY!" + name + "! "+ wishMessage;
  }
  
}
