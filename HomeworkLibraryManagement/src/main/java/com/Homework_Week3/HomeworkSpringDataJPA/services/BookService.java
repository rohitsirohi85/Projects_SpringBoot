package com.Homework_Week3.HomeworkSpringDataJPA.services;

import org.springframework.stereotype.Service;

import com.Homework_Week3.HomeworkSpringDataJPA.Repo.BookRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;

@Service
public class BookService {
    private final BookRepo bookRepo;

    
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;

    }

    public Book getBookById(Long bookId) {
       return bookRepo.findById(bookId).orElse(null);
    }

    public Book createBookById(Book book) {
     return bookRepo.save(book);
    }

    
}
