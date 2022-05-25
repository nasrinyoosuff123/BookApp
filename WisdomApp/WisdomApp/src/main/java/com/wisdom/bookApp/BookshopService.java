package com.wisdom.bookApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookshopService {
	@Autowired
	private BookRepository repo;
	
	public List<Book> listAll(){
		return repo.findAll();
	}
	
	public void save(Book book) {
		repo.save(book);
	}
	
	public Book get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
