package com.Homework_Week3.HomeworkSpringDataJPA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;

import com.Homework_Week3.HomeworkSpringDataJPA.services.BookService;

@RestController
@RequestMapping(path = "/Book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping(path = "/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public Book createBookById(@RequestBody Book book){
        return bookService.createBookById(book);
    }
}
