package com.Homework_Week3.HomeworkSpringDataJPA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author , Long> {
    
}
