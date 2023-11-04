package com.kevin.classicCarServer.car.services;

import com.kevin.classicCarServer.car.repos.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }
}
