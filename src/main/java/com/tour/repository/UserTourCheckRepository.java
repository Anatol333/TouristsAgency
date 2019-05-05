package com.tour.repository;

import com.tour.domain.User_Tour_Check;
import com.tour.domain.embeddable.EmbMiddleCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTourCheckRepository extends JpaRepository<User_Tour_Check, EmbMiddleCheck> {
    User_Tour_Check findById(int i);
}
