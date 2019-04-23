package com.tour.repository;

import com.tour.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    // custom methods ...
}
