package com.kevin.classicCarServer.car.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDetail {
    @Id
    @UuidGenerator
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @Column(length = 1000)
    private String overview;

    @Column(length = 1000)
    private String exterior;

    @Column(length = 1000)
    private String interior;

    @Column(length = 1000)
    private String engine;

    @Column(length = 1000)
    private String history;
}
