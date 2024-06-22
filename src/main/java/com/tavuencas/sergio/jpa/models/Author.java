package com.tavuencas.sergio.jpa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    /**
     * The {@code mappedBy} attribute defines the {@code authors} field in the <strong>Course</strong> class
     * as responsible for maintaining the relationship.
     */
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
