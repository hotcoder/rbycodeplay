package com.ramesh.cxf.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ramesh.cxf.vo.Book;



@WebService
public interface BookService {

	@WebMethod
	public Integer storeBook(Book book);
	
	@WebMethod
	public Book getBook(Integer id);
}
