package com.kevin.classicCarServer.car.api.dto;

import com.kevin.classicCarServer.car.models.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public record CarRequest(
        String id,
        String manufacturer,
        String model,
        Long year,
        String bodyStyle,
        Double km,
        String transmission,
        String origin,
        Integer horsepower,
        Double price,
        String detail,
        List<Image> imageList
) {
}
