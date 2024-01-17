package com.kevin.classicCarServer.seeder;

import com.kevin.classicCarServer.car.models.BodyType;
import com.kevin.classicCarServer.car.models.Car;
import com.kevin.classicCarServer.car.repository.BodyTypeRepository;
import com.kevin.classicCarServer.car.repository.CarRepository;
import com.kevin.classicCarServer.car.repository.ImageRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class DatabaseSeeder implements ApplicationRunner {

    private final CarRepository carRepository;
    private final ImageRepository imageRepository;
    private final BodyTypeRepository bodyTypeRepository;

    public DatabaseSeeder(CarRepository carRepository, ImageRepository imageRepository, BodyTypeRepository bodyTypeRepository) {
        this.carRepository = carRepository;
        this.imageRepository = imageRepository;
        this.bodyTypeRepository = bodyTypeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DBSeeder();
    }

    private void DBSeeder() {
        BodyTypeSeeder();
        TransmissionSeeder();
        ManufacturerSeeder();
    }

    private void BodyTypeSeeder() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    ResourceUtils.getFile("classicCarServer/src/main/resources/data/ClassicCar-bodyType.csv")));

            String line;
            int index = 1;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                BodyType bodyType = new BodyType();
                bodyType.setId(data[0]);
                bodyType.setName(data[1]);
                bodyTypeRepository.save(bodyType);

                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void TransmissionSeeder() {

    }

    private void ManufacturerSeeder() {

    }

    private void carSeeder() {
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

//                String[] carData = line.split(",");
//                Car car = new Car();
//                car.setId(carData[0]);
//                car.setManufacturer(carData[1]);
//                car.setModel(carData[2]);
//                car.setYear(Long.parseLong(carData[3]));
//                car.setBodyStyle(carData[4]);
//                car.setKm(Double.parseDouble(carData[5]));
//                car.setTransmission(carData[6]);
//                car.setOrigin(carData[7]);
//                car.setHorsepower(Integer.parseInt(carData[8]));
//                car.setPrice(Double.parseDouble(carData[9]));
//                car.setDetail(carData[10]);
//
//                carRepository.save(car);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
