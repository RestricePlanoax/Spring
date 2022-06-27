package com.vishnu.beans;

public class StudentBean {
	
	private String sname;
	private int sid;
	private String sclass;
	/**
	 * @return the sname
	 */
	
	static {
		System.out.println("Bean Loading");
	}
	public StudentBean() {
		System.out.println("Bean Instantiation");
	}
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		System.out.println("Bean initialising ->"+ ": "+ sname);
		this.sname = sname;
	}
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		System.out.println("Bean initialising ->"+ ": "+ sid);
		this.sid = sid;
	}
	/**
	 * @return the sclass
	 */
	public String getSclass() {
		return sclass;
	}
	/**
	 * @param sclass the sclass to set
	 */
	public void setSclass(String sclass) {
		System.out.println("Bean initialising ->"+ ": "+ sclass);
		this.sclass = sclass;
	}
	
	public void getStudentDetails() {
		System.out.println("Student name: "+ sname);
		System.out.println("Student sid: "+ sid);
		System.out.println("Student class: "+ sclass);
	}

}
