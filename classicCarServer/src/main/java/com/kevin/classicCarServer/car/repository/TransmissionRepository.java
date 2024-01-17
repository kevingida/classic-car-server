package com.kevin.classicCarServer.car.repository;

import com.kevin.classicCarServer.car.models.Transmission;
import org.springframework.data.repository.ListCrudRepository;

public interface TransmissionRepository extends ListCrudRepository<Transmission, String> {
    Transmission findByName(String name);
}
