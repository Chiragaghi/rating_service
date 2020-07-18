package com.example.RatingSystem.request;

import com.example.RatingSystem.enums.RatedBy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //to get only valid request params
public class RideRatingCreateRequest {

    @JsonProperty("rideId")
    private Long rideId;

    @JsonProperty("driverId")
    private Long driverId;

    @JsonProperty("customerId")
    private Long customerId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("ratedBy")
    private RatedBy ratedBy;

    public RatedBy getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(RatedBy ratedBy) {
        this.ratedBy = ratedBy;
    }

    public Long getRideId() {
        return rideId;
    }

    public RideRatingCreateRequest setRideId(Long rideId) {
        this.rideId = rideId;
        return this;
    }

    public Long getDriverId() {
        return driverId;
    }

    public RideRatingCreateRequest setDriverId(Long driverId) {
        this.driverId = driverId;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public RideRatingCreateRequest setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public RideRatingCreateRequest setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
