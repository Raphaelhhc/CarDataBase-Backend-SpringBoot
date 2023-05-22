package com.project.springbootcardatabase.requestmodels;

import lombok.Data;

@Data
public class AddCarRequest {

    private String modelname;

    private String brand;

    private String bodystyle;

    private String region;

    private String segment;

    private String powersource;

    private String keydimensions;

    private String powertrain;

    private String driverassistance;

    private String infotainment;

    private String img;

}
