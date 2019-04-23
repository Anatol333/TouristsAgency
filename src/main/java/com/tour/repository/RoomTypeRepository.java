package com.tour.repository;

import com.tour.domain.Room_Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<Room_Type, Integer> {

    // custom methods ...

}
