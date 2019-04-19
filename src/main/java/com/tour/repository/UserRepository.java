package com.tour.repository;

import com.tour.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom queries
    User findByUsername(String username);
    Optional<User> findById(Integer id);
}
