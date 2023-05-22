package com.project.springbootcardatabase.service;

import com.project.springbootcardatabase.dao.CarRepository;
import com.project.springbootcardatabase.dao.MyFavoriteRepository;
import com.project.springbootcardatabase.entity.Car;
import com.project.springbootcardatabase.entity.MyFavorite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarService {

    private CarRepository carRepository;

    private MyFavoriteRepository myFavoriteRepository;

    public CarService(CarRepository carRepository, MyFavoriteRepository myFavoriteRepository) {
        this.carRepository = carRepository;
        this.myFavoriteRepository = myFavoriteRepository;
    }

    public Car favoriteCar(String userEmail, Long carId) throws Exception {

        Optional<Car> car = carRepository.findById(carId);
        MyFavorite validateFavorite = myFavoriteRepository.findByUserEmailAndCarId(userEmail, carId);

        if (!car.isPresent() || validateFavorite != null ) {
            throw new Exception("Car doesn't exist or already in favorite list.");
        }

        MyFavorite myFavorite = new MyFavorite(
                userEmail,
                car.get().getId()
        );

        myFavoriteRepository.save(myFavorite);
        return car.get();

    }

    public Boolean favoriteCarByUser(String userEmail, Long carId) {

        MyFavorite validateFavorite = myFavoriteRepository.findByUserEmailAndCarId(userEmail, carId);

        if (validateFavorite != null) {
            return true;
        } else {
            return false;
        }

    }

    public int currentFavoriteCount(String userEmail) {
        return myFavoriteRepository.findCarsByUserEmail(userEmail).size();
    }

    public List<Car> currentFavorite(String userEmail) throws Exception {

        List<MyFavorite> myFavoriteList = myFavoriteRepository.findCarsByUserEmail(userEmail);
        List<Long> carIdList = new ArrayList<>();

        for (MyFavorite i : myFavoriteList) {
            carIdList.add(i.getCarId());
        }

        List<Car> cars = carRepository.findCarsByCarIds(carIdList);
        return cars;

    }

    public void removeFavorite(String userEmail, Long carId) throws Exception {

        Optional<Car> car = carRepository.findById(carId);

        MyFavorite validateFavorite = myFavoriteRepository.findByUserEmailAndCarId(userEmail, carId);

        if (!car.isPresent() || validateFavorite == null) {
            throw new Exception("Car does not exist or not in favorite list.");
        }

        myFavoriteRepository.deleteById(validateFavorite.getId());

    }

}
