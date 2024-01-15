package com.kevin.classicCarServer.car.service;

import com.kevin.classicCarServer.car.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageRepository ImageRepo;

    public ImageService(ImageRepository imageRepo) {
        ImageRepo = imageRepo;
    }
}
