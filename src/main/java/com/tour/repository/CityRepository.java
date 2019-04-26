package com.tour.repository;

import com.tour.domain.City;
import com.tour.domain.dto.TourDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    // custom
    @Query("SELECT c FROM City c INNER JOIN Tour_Content T on c.ID_City = T.ID_City" +
            " WHERE :name IN (" +
            "  SELECT c2.City_Name FROM City c2, Tour_Content tc" +
            "  WHERE c2.ID_City = tc.ID_City" +
            "  )" +
            "ORDER BY T.ID_Tour")
    List<City> getListCityByName(String name);
}
