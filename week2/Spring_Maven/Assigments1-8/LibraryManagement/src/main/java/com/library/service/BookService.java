package com.library.service;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	// Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
	public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public String toString() {
        return "BookService with BookRepository: " + bookRepository;
    }
    public void message(){
		System.out.println("Book taken");
	}
}
