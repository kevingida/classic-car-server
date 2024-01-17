package com.kevin.classicCarServer.car.repository;

import com.kevin.classicCarServer.car.models.BodyType;
import org.springframework.data.repository.ListCrudRepository;

public interface BodyTypeRepository extends ListCrudRepository<BodyType, String> {
    BodyType findByName(String name);
}
