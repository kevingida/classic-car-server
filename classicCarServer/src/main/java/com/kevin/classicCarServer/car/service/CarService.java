package com.kevin.classicCarServer.car.service;

import com.kevin.classicCarServer.car.api.dto.CarListResponse;
import com.kevin.classicCarServer.car.api.dto.CarResponse;
import com.kevin.classicCarServer.car.mapper.CarMapper;
import com.kevin.classicCarServer.car.models.Car;
import com.kevin.classicCarServer.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarService {

    private final CarRepository carRepo;

    public CarService(CarRepository repo) {
        this.carRepo = repo;
    }

    public CarListResponse getAllCars() {
        return CarMapper.toCarListResponse(carRepo.findAll()) ;
    }

    public CarResponse getCarById(String id) {
        return carRepo.findById(id)
                .map(CarMapper::toCarResponse)
                .orElseThrow(() -> new NoSuchElementException("Toy not found"));
    }
}
