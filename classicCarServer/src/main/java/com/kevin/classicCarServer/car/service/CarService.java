package com.kevin.classicCarServer.car.service;

import com.kevin.classicCarServer.car.models.Car;
import com.kevin.classicCarServer.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepo;

    public CarService(CarRepository repo) {
        this.carRepo = repo;
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }
}
