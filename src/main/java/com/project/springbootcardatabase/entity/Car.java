package com.project.springbootcardatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "modelname")
    private String modelname;

    @Column(name = "brand")
    private String brand;

    @Column(name = "bodystyle")
    private String bodystyle;

    @Column(name = "region")
    private String region;

    @Column(name = "segment")
    private String segment;

    @Column(name = "powersource")
    private String powersource;

    @Column(name = "keydimensions")
    private String keydimensions;

    @Column(name = "powertrain")
    private String powertrain;

    @Column(name = "driverassistance")
    private String driverassistance;

    @Column(name = "infotainment")
    private String infotainment;

    @Column(name = "img")
    private String img;
}
