package com.tavuencas.sergio.jpa.models.embedded;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_order")
public class Order {

    @EmbeddedId
    private OrderId orderId;

    @Embedded
    private Address address;

    private String orderInfo;
    private String anotherField;
}
