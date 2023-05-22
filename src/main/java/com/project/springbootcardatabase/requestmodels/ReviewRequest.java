package com.project.springbootcardatabase.requestmodels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {

    private double rating;

    private Long carId;

    private Optional<String> reviewDescription;

}
