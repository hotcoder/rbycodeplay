package org.yagapps.web;

public class Student {
	
	private String name;
	private int age;
	private long id;
	public Student() {
		super();
		this.name = "Ramesh";
		this.age = 28;
		this.id = 35;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
