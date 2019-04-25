package com.tour.repository;

import com.tour.domain.Tour;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {

    //Custom methods ...
     //List<Tour> findAllByPriceLessThan(Integer Price);
    @Query("SELECT t FROM Tour t where t.price < :Price")
    List<Tour> customfind(Integer Price);

}
