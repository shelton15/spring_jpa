package com.itor.example.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue
            /*(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            pkColumnValue = "id_value",
            allocationSize = 1
    )*/
    private Integer id;

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    @ManyToMany
    private List<Course> courses;
}
