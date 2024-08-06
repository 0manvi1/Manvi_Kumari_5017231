package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
    public void message(){
		System.out.println("Book added");
	}
}
