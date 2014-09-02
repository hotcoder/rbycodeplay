package com.ramesh.cxf.sei.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.ramesh.cxf.sei.BookService;
import com.ramesh.cxf.vo.Book;

@WebService(endpointInterface="com.ramesh.cxf.sei.BookService",serviceName="bookWebService")
public class BookServiceImpl implements BookService{
	
	static Map<Integer,Book> booksList = new HashMap<Integer, Book>();

	@Override
	public Integer storeBook(Book book) {
		booksList.put(book.getId(), book);
		return book.getId();
	}

	@Override
	public Book getBook(Integer id) {
		// TODO Auto-generated method stub
		return booksList.get(id);
	}

}
