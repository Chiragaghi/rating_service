package com.example.RatingSystem.entity;

import com.example.RatingSystem.enums.RatedBy;
import com.example.RatingSystem.request.RideRatingCreateRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ratings")
@Entity
public class Rating {

    @Id
    private Long rideId;

    private RatedBy ratedBy;

    private Long driverId;

    private Long customerId;

    private Integer rating;

    public Rating() {
    }

    public Rating(RideRatingCreateRequest createRequest){
        this.rideId = createRequest.getRideId();
        this.driverId = createRequest.getDriverId();
        this.customerId = createRequest.getCustomerId();
        this.rating = createRequest.getRating();
        this.ratedBy = createRequest.getRatedBy();
    }

    public Long getRideId() {
        return rideId;
    }

    public Rating setRideId(Long rideId) {
        this.rideId = rideId;
        return this;
    }

    public RatedBy getRatedBy() {
        return ratedBy;
    }

    public Rating setRatedBy(RatedBy ratedBy) {
        this.ratedBy = ratedBy;
        return this;
    }

    public Long getDriverId() {
        return driverId;
    }

    public Rating setDriverId(Long driverId) {
        this.driverId = driverId;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Rating setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Rating setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rideId=" + rideId +
                ", ratedBy=" + ratedBy +
                ", driverId=" + driverId +
                ", customerId=" + customerId +
                ", rating=" + rating +
                '}';
    }
}
