package com.itor.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    @ManyToMany
    private List<Author> authors;
}
