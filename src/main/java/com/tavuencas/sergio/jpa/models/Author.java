package com.tavuencas.sergio.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Author extends BaseEntity {

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
