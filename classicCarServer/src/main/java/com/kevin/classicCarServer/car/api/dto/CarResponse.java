package com.kevin.classicCarServer.car.api.dto;

import com.kevin.classicCarServer.car.models.Image;

import java.util.List;

public record CarResponse(
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
