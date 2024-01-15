package com.kevin.classicCarServer.car.mapper;

import com.kevin.classicCarServer.car.api.dto.CarListResponse;
import com.kevin.classicCarServer.car.api.dto.CarResponse;
import com.kevin.classicCarServer.car.models.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarResponse toCarResponse(Car car) {
        return new CarResponse(car.getId(),
                car.getManufacturer(),
                car.getModel(),
                car.getYear(),
                car.getBodyStyle(),
                car.getKm(),
                car.getTransmission(),
                car.getOrigin(),
                car.getHorsepower(),
                car.getPrice(),
                car.getDetail(),
                car.getImageList());
    }

    public static CarListResponse toCarListResponse(List<Car> cars) {
        List<CarResponse> carResponses = cars.stream()
                .map(CarMapper::toCarResponse)
                .collect(Collectors.toList());

        return new CarListResponse(carResponses);
    }
}
