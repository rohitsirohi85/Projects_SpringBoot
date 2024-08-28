package com.Homework_Week3.HomeworkSpringDataJPA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book , Long> {
    
}
