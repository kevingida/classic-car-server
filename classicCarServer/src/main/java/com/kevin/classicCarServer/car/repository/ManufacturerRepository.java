package com.kevin.classicCarServer.car.repository;

import com.kevin.classicCarServer.car.models.Manufacturer;
import org.springframework.data.repository.ListCrudRepository;

public interface ManufacturerRepository extends ListCrudRepository<Manufacturer, String> {
    Manufacturer findByName(String name);
}
