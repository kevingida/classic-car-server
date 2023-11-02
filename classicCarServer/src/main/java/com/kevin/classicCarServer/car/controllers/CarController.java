package com.kevin.classicCarServer.car.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping
    public ResponseEntity<String> getAllCars() {
        return ResponseEntity.ok("good");
    }
}
