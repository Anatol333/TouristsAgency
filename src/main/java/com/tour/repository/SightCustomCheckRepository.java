package com.tour.repository;

import com.tour.domain.Sight_Custom_Check;
import com.tour.domain.embeddable.EmbSightCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightCustomCheckRepository
        extends JpaRepository<Sight_Custom_Check, EmbSightCheck> {

    // custom methods

}
