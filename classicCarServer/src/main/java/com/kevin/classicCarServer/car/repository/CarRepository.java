package com.kevin.classicCarServer.car.repository;

import com.kevin.classicCarServer.car.models.Car;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ListCrudRepository<Car, String> {
}
