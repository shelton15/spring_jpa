package com.itor.example.repositories;

import com.itor.example.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //select * from author where first_name = 'shelton'

    List<Author> findAllByFirstName(String name);

    //select * from author where first_name like 'shel'
    List<Author> findAllByFirstNameIgnoreCase(String name); //helps ignore case of letters

    //select * from author where first_name like '%shel%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String name);

    //select * from author where first_name like 'shel%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String name);

    //select * from author where first_name like '%shel'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String name);

    //select * from author where first_name in ('shel', 'ton', 'itor')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> names);


}
