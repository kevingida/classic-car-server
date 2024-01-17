package com.kevin.classicCarServer.car.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @UuidGenerator
    private String id;
    private String model;
    private Long year;
    private Double km;
    private Integer horsepower;
    private Double price;
    private boolean sold = false;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", updatable = false,nullable = false)
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "bodyType_id", updatable = false,nullable = false)
    private BodyType bodyType;
    @ManyToOne
    @JoinColumn(name = "transmission_id", updatable = false,nullable = false)
    private Transmission transmission;

    @OneToOne(mappedBy = "car")
    private CarDetail detail;

    @OneToMany(mappedBy = "car",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Image> imageList = new ArrayList<>();

}
