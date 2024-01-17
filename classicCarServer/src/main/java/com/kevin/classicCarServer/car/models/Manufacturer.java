package com.kevin.classicCarServer.car.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
public class Manufacturer {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String origin;
}
