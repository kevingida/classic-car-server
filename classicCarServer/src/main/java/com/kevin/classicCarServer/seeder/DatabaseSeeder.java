package com.kevin.classicCarServer.seeder;

import com.kevin.classicCarServer.car.models.Car;
import com.kevin.classicCarServer.car.repository.CarRepository;
import com.kevin.classicCarServer.car.repository.ImageRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;

public class DatabaseSeeder implements ApplicationRunner {

    private final CarRepository carRepository;

    private final ImageRepository imageRepository;

    public DatabaseSeeder(CarRepository carRepository, ImageRepository imageRepository) {
        this.carRepository = carRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        carDBSeeder();
    }

    public void carDBSeeder() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    ResourceUtils.getFile("src/main/resources/data/AdaptiveFitness-BodyArea.csv")));

            String line = reader.readLine();
            boolean isFirstLine = true;

            while (line != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] carData = line.split(",");
                Car car = new Car();
                car.setId(carData[0]);
                car.setManufacturer(carData[1]);
                car.setModel(carData[2]);
                car.setYear(Long.parseLong(carData[3]));
                car.setBodyStyle(carData[4]);
                car.setKm(Double.parseDouble(carData[5]));
                car.setTransmission(carData[6]);
                car.setOrigin(carData[7]);
                car.setHorsepower(Integer.parseInt(carData[8]));
                car.setPrice(Double.parseDouble(carData[9]));
                car.setDetail(carData[10]);

                carRepository.save(car);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
