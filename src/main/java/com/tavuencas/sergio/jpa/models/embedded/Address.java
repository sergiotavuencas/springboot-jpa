package com.tavuencas.sergio.jpa.models.embedded;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Address {

    private String streetName;
    private String houseNumber;
    private String zipCode;
}
