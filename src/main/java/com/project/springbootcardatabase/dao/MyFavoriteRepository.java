package com.project.springbootcardatabase.dao;

import com.project.springbootcardatabase.entity.MyFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyFavoriteRepository extends JpaRepository<MyFavorite, Long> {

    MyFavorite findByUserEmailAndCarId(String userEmail, Long carId);

    List<MyFavorite> findCarsByUserEmail(String userEmail);

    @Query(value = "DELETE FROM myfavorite WHERE car_id IN (:car_id)", nativeQuery = true)
    @Modifying
    void deleteAllByCarId(@Param("car_id") Long carId);

}
