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

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @Column(columnDefinition = "text")
    private String overview;

    @Column(columnDefinition = "text")
    private String exterior;

    @Column(columnDefinition = "text")
    private String interior;

    @Column(columnDefinition = "text")
    private String engine;

    @Column(columnDefinition = "text")
    private String history;
}
