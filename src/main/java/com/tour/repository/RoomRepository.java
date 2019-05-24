package com.tour.repository;

import com.tour.domain.Room;
import com.tour.domain.embeddable.EmbRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, EmbRoom> {

    // custom methods ...
    @Query("SELECT Count(R.ID_Room) + 1 FROM Room R" +
            " WHERE R.ID_Hotel = :hotel")
    Integer getID_RoomInHotel(final Integer hotel);
}
