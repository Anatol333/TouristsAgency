package com.tour.repository;

import com.tour.domain.Hotel;
import com.tour.domain.Room_Service;
import com.tour.domain.User_Tour_Check;
import com.tour.domain.embeddable.EmbMiddleCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTourCheckRepository extends JpaRepository<User_Tour_Check, EmbMiddleCheck> {
    User_Tour_Check findById(int i);

    //Find Room list in Hotel by id
    @Query("SELECT R.ID_Room FROM Hotel H, Room R" +
            " WHERE H.ID_Hotel = :id AND " +
            "       H.ID_Hotel = R.ID_Hotel")
    List<Integer> findListHotelByID(final Integer id);

    //Find Hotel list by id
    @Query("SELECT R.ID_Service FROM Room_Service R" +
            " WHERE R.ID_Room = :id_room" )
    List<Integer> findListServiceByID(final Integer id_room);

    @Query("SELECT R.ID_Service FROM Room_Service R" +
            " WHERE R.ID_Service = :service " +
            "   AND R.ID_Room = :room ")
    Integer findFignya(final Integer service, Integer room);
}
