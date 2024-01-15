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
    private String manufacturer;
    private String model;
    private Long year;
    private String bodyStyle;
    private Double km;
    private String transmission;
    private String origin;
    private Integer horsepower;
    private Double price;
    @Column(columnDefinition = "text")
    private String detail;
    private boolean sold = false;
    @OneToMany(mappedBy = "car",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Image> imageList = new ArrayList<>();

}
