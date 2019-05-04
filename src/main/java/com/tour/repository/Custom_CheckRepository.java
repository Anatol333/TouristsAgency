package com.tour.repository;

import com.tour.domain.Custom_Check;
import com.tour.domain.embeddable.EmbCustom_Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Custom_CheckRepository extends JpaRepository<Custom_Check, EmbCustom_Check> {

    // Some custom methods....

}
