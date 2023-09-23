package com.samyak.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_SEQ")
    @SequenceGenerator(name = "address_SEQ", sequenceName = "address_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="zipCode")
    private String zipCode;
}
