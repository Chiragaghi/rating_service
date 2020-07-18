package com.example.RatingSystem.repository;

import com.example.RatingSystem.entity.Rating;
import com.example.RatingSystem.enums.RatedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepo extends JpaRepository<Rating, Long> {

    @Query("SELECT sum(r.rating) from Rating r where r.customerId = :id AND r.ratedBy = :ratedBy")
    Long getTotalCustomerRating(@Param("id") Long customerId, @Param("ratedBy") RatedBy ratedBy);

    @Query("SELECT sum(r.rating) from Rating r where r.driverId = :id AND r.ratedBy = :ratedBy")
    Long getTotalDriverRating(@Param("id") Long driverId, @Param("ratedBy") RatedBy ratedBy);

    @Query("SELECT count(r.rating) from Rating r where r.customerId = :id AND r.ratedBy = :ratedBy")
    Long getRatingCountForCustomer(@Param("id") Long customerId, @Param("ratedBy") RatedBy ratedBy);

    @Query("SELECT count(r.rating) from Rating r where r.driverId = :id AND r.ratedBy = :ratedBy")
    Long getRatingCountForDriver(@Param("id") Long driverId, @Param("ratedBy") RatedBy ratedBy);

}
