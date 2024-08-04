package com.Homework_Week3.HomeworkSpringDataJPA.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Homework_Week3.HomeworkSpringDataJPA.Repo.AuthorRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.Repo.BookRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;

@Service
public class AuthorService {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    
    public AuthorService(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public Author getAuthorById(Long authorId) {
      return authorRepo.findById(authorId).orElse(null);
    }

    public Author createNewAuthor(Author author) {
       return authorRepo.save(author);
    }

    public Author assignBookToAuthor(Long authorId, Long bookId) {
      Optional< Author> author =authorRepo.findById(authorId);
       Optional<Book> book=bookRepo.findById(bookId);

       return author.flatMap(authors->book.map(books->{
               books.setAuthor(authors);
               bookRepo.save(books);

               authors.getBooks().add(books);
               return authorRepo.save(authors);

       })).orElse(null);
    }

    
}
