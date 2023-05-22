package com.project.springbootcardatabase.controller;

import com.project.springbootcardatabase.requestmodels.ReviewRequest;
import com.project.springbootcardatabase.service.ReviewService;
import com.project.springbootcardatabase.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://web-cardatabase-react.onrender.com")
@RestController
@RequestMapping("/api")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController (ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/secure/reviews/user/car")
    public Boolean reviewCarByUser(@RequestHeader(value="Authorization") String token,
                                   @RequestParam Long carId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail, carId);
    }

    @PostMapping("/secure/reviews")
    public void postReview(@RequestHeader(value="Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }
}
