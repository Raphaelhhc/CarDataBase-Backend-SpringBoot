package com.project.springbootcardatabase.controller;

import com.project.springbootcardatabase.entity.Car;
import com.project.springbootcardatabase.service.CarService;
import com.project.springbootcardatabase.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://web-cardatabase-react.onrender.com")
@RestController
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/secure/cars/currentfavorite")
    public List<Car> currentFavorite(@RequestHeader(value = "Authorization") String token) throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return carService.currentFavorite(userEmail);
    }

    @GetMapping("/secure/cars/currentfavorite/count")
    public int currentFavoriteCount(@RequestHeader(value = "Authorization") String token) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return carService.currentFavoriteCount(userEmail);
    }

    @GetMapping("/secure/cars/isfavorite/byuser")
    public Boolean favoriteCarByUser(@RequestHeader(value = "Authorization") String token,
                                     @RequestParam Long carId) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return carService.favoriteCarByUser(userEmail, carId);
    }

    @PutMapping("/secure/cars/favorite")
    public Car favoriteCar(@RequestHeader(value = "Authorization") String token,
                           @RequestParam Long carId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return carService.favoriteCar(userEmail, carId);
    }

    @PutMapping("/secure/cars/removefavorite")
    public void removeFavorite(@RequestHeader(value = "Authorization") String token,
                               @RequestParam Long carId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        carService.removeFavorite(userEmail, carId);
    }
}
