package com.tour.repository;

import com.tour.domain.City_Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityTourRepository extends JpaRepository<City_Tour, Integer> {

    // Custom methods ...


}
