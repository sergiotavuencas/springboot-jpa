package com.tavuencas.sergio.jpa.repositories;

import com.tavuencas.sergio.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

// Specification is used when dealing with complex queries that depends on user input or runtime condition
public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    // SELECT * FROM author WHERE LOWER(last_name) = 'tavuencas'
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.courses WHERE a.lastName = :lastName")
    List<Author> findAllByLastName(@Param("lastName") String lastName);

    // SELECT * FROM author WHERE LOWER(last_name) = 'vu'
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.courses WHERE LOWER(a.lastName) = LOWER(:lastName)")
    List<Author> findAllByLastNameIgnoreCase(@Param("lastName") String lastName);

    // SELECT * FROM author WHERE LOWER(last_name) LIKE '%vu%'
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.courses WHERE LOWER(a.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))")
    List<Author> findAllByLastNameContainingIgnoreCase(@Param("lastName") String lastName);

    // SELECT * FROM author WHERE LOWER(last_name) LIKE '%vu'
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.courses WHERE LOWER(a.lastName) LIKE LOWER(CONCAT('%', :lastName))")
    List<Author> findAllByLastNameEndsWithIgnoreCase(@Param("lastName") String lastName);

    // SELECT * FROM author WHERE LOWER(last_name) IN ('tavuencas', 'vicente')
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.courses WHERE LOWER(a.lastName) IN :lastNames")
    List<Author> findAllByLastNameInIgnoreCase(@Param("lastNames") List<String> lastNames);

    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.email = :email WHERE a.lastName = :lastName")
    void updateAuthorEmail(String email, String lastName);

    // Named Query
    List<Author> findByFirstName(@Param("firstName") String firstName);
}
