package com.example.RatingSystem.controller;

import com.example.RatingSystem.entity.Rating;
import com.example.RatingSystem.request.RideRatingCreateRequest;
import com.example.RatingSystem.response.BaseObjectResponse;
import com.example.RatingSystem.response.ServiceResponse;
import com.example.RatingSystem.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
public class RatingsController {

    @Autowired
    RatingsService ratingsService;

    @PostMapping
    private ServiceResponse<BaseObjectResponse<Boolean>> createRating(@RequestBody RideRatingCreateRequest request){
        Rating rating = new Rating(request);
        Boolean saved = ratingsService.createRating(rating);
        return new ServiceResponse<>(new BaseObjectResponse<>(saved));
    }

    @GetMapping
    private ServiceResponse<BaseObjectResponse<Double>> getAvgRating(@RequestParam(value = "customer_id",
                                                                                   required = false) Long customerId,
                                                                     @RequestParam(value = "driver_id",
                                                                                   required = false) Long driverId){
        if(!(customerId == null ^ driverId == null))
            return new ServiceResponse<>(new BaseObjectResponse<>(
                    422, "Only One of customer_id and driver_id must be present.", null),
                                         HttpStatus.BAD_REQUEST);

        double avgRating;
        if(customerId != null){
            avgRating = ratingsService.getAvgRating(customerId, true);
        }else{
            avgRating = ratingsService.getAvgRating(driverId, false);
        }

        return new ServiceResponse<>(new BaseObjectResponse<>(avgRating));

    }
}
