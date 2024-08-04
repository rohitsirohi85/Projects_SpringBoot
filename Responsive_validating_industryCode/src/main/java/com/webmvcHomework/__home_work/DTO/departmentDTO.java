package com.webmvcHomework.__home_work.DTO;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.webmvcHomework.__home_work.customAnnotation.passwordAnotation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class departmentDTO {

    private Long id;

    /* for title */
    @NotNull(message = "title cannot be null")  // these annotations are only valid when you use valid dependency in pom.xml and use @valid annotation in the mappings
    @Length(min = 5 , max = 8)
    private String title;

    /* for isActive */
    @Pattern(regexp = "^yes|no$" , message = "isActive can be only yes or no")
    private String isActive;

    /* for password */
    @passwordAnotation
    @NotNull
    private String password;

    /* for date */
    @PastOrPresent(message = "are you coming from future")
    private LocalDate createdAt;
    

}
