package com.meze.atmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meze.atmapi.model.Book;
import com.meze.atmapi.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> list() {
		return bookRepository.findAll();
	}

}
