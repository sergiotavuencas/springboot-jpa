package com.tavuencas.sergio.jpa.models;

import jakarta.persistence.*;
import lombok.*;

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

    /**
     * The {@code @JoinTable} annotation creates a new joining table
     * between <strong>Author</strong> and <strong>Course</strong>.<br>
     * The {@code name} attribute defines the table's name.<br>
     * The {@code joinColumns} attribute defines which columns will hold
     * the foreign key for the <strong>Course</strong> entity.<br>
     * The {@code inverseJoinColumns} attribute defines which columns will hold
     * the foreign key for the <strong>Author</strong> entity.<br>
     */
    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;
}
