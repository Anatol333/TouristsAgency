package com.tour.repository;

import com.tour.domain.Room_Service;
import com.tour.domain.embeddable.EmbRoom_Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomServiceRepository
        extends JpaRepository<Room_Service, EmbRoom_Service> {

    // custom methods ...
}
