package com.tour.repository;

import com.tour.domain.EmbTour_Content;
import com.tour.domain.Tour_Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourContentRepository extends JpaRepository<Tour_Content, EmbTour_Content> {

    // Custo methods ...


}
