package com.Homework_Week3.HomeworkSpringDataJPA.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Author")
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String name;

  @OneToMany(mappedBy = "author" )
  @JsonIgnore
  private List<Book>books;

}
