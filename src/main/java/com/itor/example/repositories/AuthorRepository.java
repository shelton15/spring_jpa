package com.itor.example.repositories;

import com.itor.example.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByNamedQuery(@Param("age") int age);

    //update Author a set a.age = 22 where a.id = 1
    @Transactional
    @Modifying
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

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
