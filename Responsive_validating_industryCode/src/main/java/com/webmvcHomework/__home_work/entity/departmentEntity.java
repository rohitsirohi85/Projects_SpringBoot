package com.webmvcHomework.__home_work.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data  // holds the getter and setter for us
@AllArgsConstructor
@NoArgsConstructor
@Table(name="department")
public class departmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isActive;
    private String password;
    private LocalDate createdAt;

}
