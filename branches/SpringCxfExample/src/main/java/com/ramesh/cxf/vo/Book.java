package com.ramesh.cxf.vo;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="book")
public class Book {
	
	String name;
	Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
