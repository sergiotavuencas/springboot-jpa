package com.tavuencas.sergio.jpa.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Resources {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;
}
