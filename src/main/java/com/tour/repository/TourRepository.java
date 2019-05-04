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

    @Query("SELECT T FROM Tour T INNER JOIN Tour_Content TC on T.ID_Tour = TC.ID_Tour" +
            " WHERE TC.ID_City IN (" +
            "   SELECT TC2.ID_City FROM Tour_Content TC2 INNER JOIN City C on TC2.ID_City = C.ID_City" +
            "   WHERE C.City_Name = :name" +
            "   ) " +
            "   AND T.price < :price" +
            " ORDER BY T.ID_Tour")
    List<Tour> findTourInCity(final String name, Integer price);

    @Query("SELECT T FROM Tour T WHERE T.ID_Tour = :id")
    Tour findOneTourID(final Integer id);
}
