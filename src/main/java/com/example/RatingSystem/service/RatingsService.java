package com.example.RatingSystem.service;

import com.example.RatingSystem.entity.Rating;
import com.example.RatingSystem.enums.RatedBy;
import com.example.RatingSystem.repository.RatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingsService {

    @Autowired
    RatingsRepo repo;


    public Boolean createRating(Rating rating){
         Rating r = repo.save(rating);
         return r == null ? false : true;
    }

    public Double getAvgRating(Long id, Boolean forCustomer){
        Long totalRating, totalCount;
        if(forCustomer){
            totalCount = repo.getRatingCountForCustomer(id, RatedBy.DRIVER);
            totalRating = repo.getTotalCustomerRating(id, RatedBy.DRIVER);
        }else{
            totalCount = repo.getRatingCountForDriver(id, RatedBy.CUSTOMER);
            totalRating = repo.getTotalDriverRating(id, RatedBy.CUSTOMER);
        }

        if(totalCount == 0) return 0d;
        return (double)totalRating/totalCount;
    }
}
