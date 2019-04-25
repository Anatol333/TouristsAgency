package com.tour.repository;

import com.tour.domain.embeddable.EmbTour_Content;
import com.tour.domain.Tour_Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourContentRepository extends JpaRepository<Tour_Content, EmbTour_Content> {

    // Custo methods ...

    @Query("SELECT tc from Tour_Content tc INNER JOIN City c ON tc.ID_City = c.ID_City " +
            "where c.City_Name = :name")
    List<Tour_Content> findCityCustomName(String name);
}
