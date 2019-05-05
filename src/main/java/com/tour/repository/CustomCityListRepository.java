package com.tour.repository;

import com.tour.domain.Custom_City_List;
import com.tour.domain.Sight;
import com.tour.domain.embeddable.EmbCustom_City_List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomCityListRepository
        extends JpaRepository<Custom_City_List, EmbCustom_City_List> {

    // custom methods
    @Query("SELECT CT.ID_City_Tour FROM City_Tour CT " +
            " WHERE CT.ID_Sight IN :sights")
    List<Integer> getListCityForUser(final List<Integer> sights);
}
