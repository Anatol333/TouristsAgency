package com.tour.service;

import com.tour.domain.User;
import com.tour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // DataBase methods for user

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
