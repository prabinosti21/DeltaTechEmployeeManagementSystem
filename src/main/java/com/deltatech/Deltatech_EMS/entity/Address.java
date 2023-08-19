package com.deltatech.Deltatech_EMS.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "aid_generator")
    @SequenceGenerator(name = "aid_generator", sequenceName = "address_generator")
    private Long aid;
    private String street, city, state;
    private Integer zipCode;
}
