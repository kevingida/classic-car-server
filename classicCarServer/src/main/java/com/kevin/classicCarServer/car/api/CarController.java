package com.kevin.classicCarServer.car.api;

import com.kevin.classicCarServer.car.api.dto.CarListResponse;
import com.kevin.classicCarServer.car.api.dto.CarResponse;
import com.kevin.classicCarServer.car.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService  service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public CarListResponse getAllCars() {
        return service.getAllCars();
    }

    @GetMapping("/{carId}")
    public CarResponse getCarById(@PathVariable String carId) {
        return service.getCarById(carId);
    }
}
