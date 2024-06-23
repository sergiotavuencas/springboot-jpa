package com.tavuencas.sergio.jpa;

import com.github.javafaker.Faker;
import com.tavuencas.sergio.jpa.models.Author;
import com.tavuencas.sergio.jpa.models.Video;
import com.tavuencas.sergio.jpa.repositories.AuthorRepository;
import com.tavuencas.sergio.jpa.repositories.VideoRepository;
import com.tavuencas.sergio.jpa.specification.AuthorSpecification;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            VideoRepository videoRepository,
            AuthorRepository authorRepository
    ) {
        return args -> {
            // Creating fake authors for testing using Faker
//            for (int i = 0; i < 50; i++) {
//                Faker faker = new Faker();
//                String fname = faker.name().firstName();
//                String lname = faker.name().lastName();
//
//                var author = Author.builder()
//                        .firstName(fname)
//                        .lastName(lname)
//                        .email(fname.toLowerCase() + "." + lname.toLowerCase() + "@gmail.com")
//                        .createdAt(LocalDateTime.now())
//                        .lastModifiedAt(LocalDateTime.now())
//                        .createdBy("sys")
//                        .lastModifiedBy("sys")
//                        .build();
//                authorRepository.save(author);
//            }

//            authorRepository.updateAuthorEmail("scottie@gmail.com", "Hammes");

            // As JPQL does not allow to use of LOWER() with IN, it is necessary to modify each value inside a List<String> using toLowerCase()
//            List<String> lastNames = Stream.of("Goldner", "Hammes", "Heaney")
//                    .map(String::toLowerCase)
//                    .collect(Collectors.toList());
//
//            List<Author> authorsByLastNameIn = authorRepository.findAllByLastNameInIgnoreCase(lastNames);
//
//            if (!authorsByLastNameIn.isEmpty()) {
//                authorsByLastNameIn.forEach(System.out::println);
//            }
//
//            authorRepository.findByFirstName("Desmond")
//                    .forEach(System.out::println);

            Specification<Author> spec = Specification
                    .where(AuthorSpecification.firstNameContains("esm"))
                    .and(AuthorSpecification.lastNameContains("teh"));

            authorRepository.findAll(spec).forEach(System.out::println);
        };
    }
}
