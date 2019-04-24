package com.tour.repository;

import com.tour.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services, Integer> {

    // custom methods ...

}
