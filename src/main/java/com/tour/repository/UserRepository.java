package com.tour.repository;

import com.tour.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom queries
}
