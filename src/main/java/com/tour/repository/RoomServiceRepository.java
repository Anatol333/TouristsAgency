package com.tour.repository;

import com.tour.domain.City;
import com.tour.domain.Room_Service;
import com.tour.domain.dto.*;
import com.tour.domain.embeddable.EmbRoom_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomServiceRepository
        extends JpaRepository<Room_Service, EmbRoom_Service> {

    // custom methods ...

    @Query("SELECT new com.tour.domain.dto.HotelDTO(H.ID_Hotel, R.ID_Room, S.ID_Service, H.Name_Hotel, S.Name_Service, S.Price_Service) FROM Room_Service RS, Hotel H, Services S, Room R " +
            " WHERE RS.ID_Hotel = H.ID_Hotel " +
            "  AND RS.ID_Room = R.ID_Room " +
            "  AND RS.ID_Service = S.ID_Service " +
            "  AND H.ID_City IN :cities ")
    List<HotelDTO> getFullHotelInfo(final List<Integer> cities);

    @Query("SELECT distinct new com.tour.domain.dto.RoomHotelDTO(R.ID_Room, H.ID_Hotel) FROM Room_Service RS, Hotel H, Services S, Room R " +
            " WHERE RS.ID_Hotel = H.ID_Hotel " +
            "  AND RS.ID_Room = R.ID_Room " +
            "  AND RS.ID_Service = S.ID_Service " +
            "  AND H.ID_City IN :cities " +
            " ORDER BY R.ID_Room")
    List<RoomHotelDTO> getJustRoomInfo(final List<Integer> cities);

    @Query("SELECT new com.tour.domain.dto.RoomDTO(R.ID_Room, S.ID_Service, S.Name_Service)  FROM Room_Service RS, Hotel H, Services S, Room R " +
            " WHERE RS.ID_Hotel = H.ID_Hotel " +
            "  AND RS.ID_Room = R.ID_Room " +
            "  AND RS.ID_Service = S.ID_Service " +
            "  AND H.ID_City IN :cities ")
    List<RoomDTO> getFullRoomInfo(final List<Integer> cities);

    @Query("SELECT new com.tour.domain.dto.ServiceRoomDTO(R.ID_Room, H.ID_Hotel, S.ID_Service, S.Name_Service, S.Price_Service)  FROM Room_Service RS, Hotel H, Services S, Room R " +
            " WHERE RS.ID_Hotel = H.ID_Hotel " +
            "  AND RS.ID_Room = R.ID_Room " +
            "  AND RS.ID_Service = S.ID_Service " +
            "  AND H.ID_City IN :cities ")
    List<ServiceRoomDTO> getFullRoomInfoPrice(final List<Integer> cities);


    @Query("SELECT DISTINCT H FROM Room_Service RS, Hotel H, Services S, Room R " +
            " WHERE RS.ID_Hotel = H.ID_Hotel " +
            "  AND RS.ID_Room = R.ID_Room " +
            "  AND RS.ID_Service = S.ID_Service " +
            "  AND H.ID_City IN :cities ")
    List<Integer> getJustHotelInfo(final List<Integer> cities);

    @Query("SELECT DISTINCT S FROM Room_Service RS, Hotel H, Services S, Room R " +
            " WHERE RS.ID_Hotel = H.ID_Hotel " +
            "  AND RS.ID_Room = R.ID_Room " +
            "  AND RS.ID_Service = S.ID_Service " +
            "  AND H.ID_City IN :cities ")
    List<Integer> getJustServiceInfo(final List<Integer> cities);
}
