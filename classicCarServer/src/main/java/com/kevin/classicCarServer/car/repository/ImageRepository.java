package com.kevin.classicCarServer.car.repository;

import com.kevin.classicCarServer.car.models.Image;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends ListCrudRepository<Image, String> {
}
