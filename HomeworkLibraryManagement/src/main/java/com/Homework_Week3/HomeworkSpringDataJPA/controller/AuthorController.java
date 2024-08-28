package com.Homework_Week3.HomeworkSpringDataJPA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;
import com.Homework_Week3.HomeworkSpringDataJPA.services.AuthorService;

@RestController
@RequestMapping(path = "/Author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    public Author createNewAuthor(@RequestBody Author author){
            return authorService.createNewAuthor(author);
    }

    @PutMapping(path = "/{authorId}/Book/{bookId}")
    public Author assignBookToAuthor(@PathVariable Long authorId , @PathVariable Long bookId ){
        return authorService.assignBookToAuthor(authorId,bookId);
    }



}
