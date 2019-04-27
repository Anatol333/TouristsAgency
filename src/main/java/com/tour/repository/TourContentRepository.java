package com.tour.repository;

import com.tour.domain.Sight;
import com.tour.domain.dto.TourDTO;
import com.tour.domain.embeddable.EmbTour_Content;
import com.tour.domain.Tour_Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourContentRepository extends JpaRepository<Tour_Content, EmbTour_Content> {

    // Custo methods ...

    @Query("SELECT new com.tour.domain.dto.TourDTO(T1.ID_Tour, T1.ID_City, C1.City_Name) FROM City C1 INNER JOIN Tour_Content T1 on C1.ID_City = T1.ID_City" +
            "  WHERE T1.ID_Tour IN (" +
            "    SELECT T.ID_Tour " +
            "    FROM City c" +
            "           INNER JOIN Tour_Content T on c.ID_City = T.ID_City" +
            "    WHERE :id = (" +
            "      SELECT tc.ID_Tour" +
            "      FROM City c2," +
            "           Tour_Content tc" +
            "      WHERE c2.ID_City = tc.ID_City" +
            "        AND c.ID_City = c2.ID_City" +
            "    )" +
            "  )" +
            " ORDER BY T1.ID_Tour")
    TourDTO getListTourContentById(final Integer id);

    @Query("SELECT new com.tour.domain.dto.TourDTO(T.ID_Tour, T.ID_City, c.City_Name) " +
            " FROM City c INNER JOIN Tour_Content T on c.ID_City = T.ID_City" +
            " WHERE c.City_Name IN (" +
            "  SELECT c2.City_Name FROM City c2, Tour_Content tc" +
            "  WHERE c2.ID_City = tc.ID_City" +
            "  )" +
            "ORDER BY T.ID_Tour")
    List<TourDTO> getListTourContentAll();

}
