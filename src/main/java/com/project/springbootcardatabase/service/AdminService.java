package com.project.springbootcardatabase.service;

import com.project.springbootcardatabase.dao.CarRepository;
import com.project.springbootcardatabase.dao.MyFavoriteRepository;
import com.project.springbootcardatabase.dao.ReviewRepository;
import com.project.springbootcardatabase.entity.Car;
import com.project.springbootcardatabase.requestmodels.AddCarRequest;
import com.project.springbootcardatabase.requestmodels.EditCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private CarRepository carRepository;
    private ReviewRepository reviewRepository;
    private MyFavoriteRepository myFavoriteRepository;

    @Autowired
    public AdminService(CarRepository carRepository,
                        ReviewRepository reviewRepository,
                        MyFavoriteRepository myFavoriteRepository) {
        this.carRepository = carRepository;
        this.reviewRepository = reviewRepository;
        this.myFavoriteRepository = myFavoriteRepository;
    }

    public void postCar(AddCarRequest addCarRequest) {

        Car car = new Car();

        car.setModelname(addCarRequest.getModelname());
        car.setBrand(addCarRequest.getBrand());
        car.setBodystyle(addCarRequest.getBodystyle());
        car.setRegion(addCarRequest.getRegion());
        car.setSegment(addCarRequest.getSegment());
        car.setPowersource(addCarRequest.getPowersource());
        car.setKeydimensions(addCarRequest.getKeydimensions());
        car.setPowertrain(addCarRequest.getPowertrain());
        car.setDriverassistance(addCarRequest.getDriverassistance());
        car.setInfotainment(addCarRequest.getInfotainment());
        car.setImg(addCarRequest.getImg());

        carRepository.save(car);

    }

    public void updateCarInfo(Long carId, EditCarRequest editCarRequest) throws Exception {

        Optional<Car> car = carRepository.findById(carId);

        if (!car.isPresent()) {
            throw new Exception("Car not found");
        }

        car.get().setModelname(editCarRequest.getModelname());
        car.get().setBrand(editCarRequest.getBrand());
        car.get().setBodystyle(editCarRequest.getBodystyle());
        car.get().setRegion(editCarRequest.getRegion());
        car.get().setSegment(editCarRequest.getSegment());
        car.get().setPowersource(editCarRequest.getPowersource());
        car.get().setKeydimensions(editCarRequest.getKeydimensions());
        car.get().setPowertrain(editCarRequest.getPowertrain());
        car.get().setDriverassistance(editCarRequest.getDriverassistance());
        car.get().setInfotainment(editCarRequest.getInfotainment());

        carRepository.save(car.get());

    }

    public void deleteCar(Long carId) throws Exception {

        Optional<Car> car = carRepository.findById(carId);

        if (!car.isPresent()) {
            throw new Exception("Car not found");
        }

        carRepository.delete(car.get());
        reviewRepository.deleteAllByCarId(carId);
        myFavoriteRepository.deleteAllByCarId(carId);

    }

}
