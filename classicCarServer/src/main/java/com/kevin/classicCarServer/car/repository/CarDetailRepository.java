package com.kevin.classicCarServer.car.repository;

import com.kevin.classicCarServer.car.models.CarDetail;
import org.springframework.data.repository.ListCrudRepository;

public interface CarDetailRepository extends ListCrudRepository<CarDetail, String> {
}
