package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
public class CarController {

    @Autowired
    private HttpServletRequest request;

    private List<Car> cars = new ArrayList<>();

    public CarController() {
        cars = Arrays.asList(new Car.CarBuilder()
                        .setMake("Honda").setModel("Civic").setYear(2017).setUsed(true).createCar(),
                new Car.CarBuilder()
                        .setMake("Audi").setModel("A4").setYear(1998).setUsed(true).createCar(),
                new Car.CarBuilder()
                        .setMake("Renault").setModel("5").setYear(1984).setUsed(true).createCar());

        cars.forEach(car -> {
            car.getLocalizedNameOld().add(Locale.FRANCE, "message français");
            car.getLocalizedNameOld().add(Locale.ENGLISH, "english message");
            car.getLocalizedName().setName("message");
            car.getLocalizedName().setDisplayName("message");
            car.getLocalizedName().getLocalizedName().put(Locale.FRANCE, "message français");
            car.getLocalizedName().getLocalizedName().put(Locale.ENGLISH, "english message");
        });
    }

    @GetMapping("/v1/car")
    @ResponseStatus(HttpStatus.OK)
    List<Car> getCarsV1() {
        return getCars();
    }

    @GetMapping("/v2/car")
    @ResponseStatus(HttpStatus.OK)
    List<Car> getCarsV2() {
        return getCars();
    }

    @GetMapping("/v3/car")
    @ResponseStatus(HttpStatus.OK)
    List<Car> getCarsV3() {
        return getCars();
    }

    private List<Car> getCars() {
        cars.forEach(System.out::println);
        String version = getVersion();
        cars.forEach(car -> car.setSerializeToVersion(version));
        return cars;
    }

    private String getVersion() {
        String[] urlParts = request.getRequestURI().split("/");
        return urlParts[1].substring(1);
    }
}
