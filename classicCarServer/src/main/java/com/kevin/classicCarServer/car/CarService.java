package com.kevin.classicCarServer.car;

import com.kevin.classicCarServer.car.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }
}
