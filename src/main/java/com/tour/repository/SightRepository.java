package com.tour.repository;

import com.tour.domain.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Integer> {
    // Custom methods ...

}
