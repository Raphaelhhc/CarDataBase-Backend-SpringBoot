package com.project.springbootcardatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "myfavorite")
@Data
public class MyFavorite {

    public MyFavorite() {}

    public MyFavorite(String userEmail, Long carId) {
        this.userEmail = userEmail;
        this.carId = carId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "car_id")
    private long carId;
}
