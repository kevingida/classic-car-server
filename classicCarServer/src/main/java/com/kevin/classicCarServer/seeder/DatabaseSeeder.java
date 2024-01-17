package com.kevin.classicCarServer.seeder;

import com.kevin.classicCarServer.car.models.*;
import com.kevin.classicCarServer.car.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class DatabaseSeeder implements ApplicationRunner {

    private final CarRepository carRepository;
    private final CarDetailRepository carDetailRepository;
    private final ImageRepository imageRepository;
    private final BodyTypeRepository bodyTypeRepository;
    private final TransmissionRepository transmissionRepository;
    private final ManufacturerRepository manufacturerRepository;

    public DatabaseSeeder(CarRepository carRepository, CarDetailRepository carDetailRepository, ImageRepository imageRepository, BodyTypeRepository bodyTypeRepository, TransmissionRepository transmissionRepository, ManufacturerRepository manufacturerRepository) {
        this.carRepository = carRepository;
        this.carDetailRepository = carDetailRepository;
        this.imageRepository = imageRepository;
        this.bodyTypeRepository = bodyTypeRepository;
        this.transmissionRepository = transmissionRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DBSeeder();
        carSeeder();
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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    ResourceUtils.getFile("classicCarServer/src/main/resources/data/ClassicCar-transmission.csv")));

            String line;
            int index = 1;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                Transmission transmission = new Transmission();
                transmission.setId(data[0]);
                transmission.setName(data[1]);
                transmissionRepository.save(transmission);

                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ManufacturerSeeder() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    ResourceUtils.getFile("classicCarServer/src/main/resources/data/ClassicCar-manufacturer.csv")));

            String line;
            int index = 1;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(data[0]);
                manufacturer.setName(data[1]);
                manufacturer.setOrigin(data[2]);
                manufacturerRepository.save(manufacturer);

                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carSeeder() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    ResourceUtils.getFile("classicCarServer/src/main/resources/data/ClassicCar-car.csv")));

            String line;
            int index = 1;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Car car = new Car();
                car.setModel(data[1]);
                car.setYear(Integer.parseInt(data[2]));
                car.setKm(Integer.parseInt(data[3]));
                car.setHorsepower(Integer.parseInt(data[4]));
                car.setPrice(Integer.parseInt(data[5]));
                car.setManufacturer(manufacturerRepository.findByName(data[6]));
                car.setBodyType(bodyTypeRepository.findByName(data[7]));
                car.setTransmission(transmissionRepository.findByName(data[8]));
                Car newCar = carRepository.save(car);

                CarDetail carDetail = new CarDetail();
                carDetail.setCar(carRepository.findById(newCar.getId()).get());
                carDetail.setOverview(data[9]);
                carDetail.setExterior(data[10]);
                carDetail.setInterior(data[11]);
                carDetail.setEngine(data[12]);
                carDetail.setHistory(data[13]);

                carDetailRepository.save(carDetail);

            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
