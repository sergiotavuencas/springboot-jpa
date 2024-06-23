package com.tavuencas.sergio.jpa.specification;

import com.tavuencas.sergio.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> firstNameContains(String firstName) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (firstName == null) {
                return null;
            }

            // Necessary to avoid LazyInitializationException
            root.fetch("courses", JoinType.LEFT);

            // Removes the duplicates that can be caused by JOIN FETCH
            query.distinct(true);

            return builder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }

    public static Specification<Author> lastNameContains(String lastName) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (lastName == null) {
                return null;
            }

            // Necessary to avoid LazyInitializationException
            root.fetch("courses", JoinType.LEFT);

            // Removes the duplicates that can be caused by JOIN FETCH
            query.distinct(true);

            return builder.like(root.get("lastName"), "%" + lastName + "%");
        };
    }
}
