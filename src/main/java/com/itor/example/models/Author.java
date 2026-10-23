package com.itor.example.models;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
public class Author {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

}
