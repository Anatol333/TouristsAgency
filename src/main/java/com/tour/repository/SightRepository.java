package com.tour.repository;

import com.tour.domain.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.ws.Service;
import java.util.List;

public interface SightRepository extends JpaRepository<Sight, Integer> {
    // Custom methods ...
    @Query("SELECT S FROM Tour_Content T INNER JOIN City C on T.ID_City = C.ID_City, City_Tour CT, Sight S" +
            " WHERE T.ID_Tour = :id" +
            "  AND CT.ID_City = T.ID_City" +
            "  AND CT.ID_Sight = S.ID_Sight" +
            " ORDER BY T.ID_Tour")
    List<Sight> getListSightForTournotworking(final Integer id);

    @Query("SELECT S FROM Tour_Content T INNER JOIN City C on T.ID_City = C.ID_City, Sight S" +
            " WHERE T.ID_Tour = :id" +
            "  AND S.ID_City = T.ID_City" +
            " ORDER BY T.ID_Tour")
    List<Sight> getListSightForTour(final Integer id);


    @Query("SELECT RS.ID_Service FROM Room_Service RS" +
            " WHERE RS.ID_Service = :services AND " +
            "       RS.ID_Room = :room")
    Integer getListServiceInCity(final Integer services, final Integer room);

}
