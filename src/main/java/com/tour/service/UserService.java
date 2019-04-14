package com.tour.service;

import com.tour.domain.Role;
import com.tour.domain.User;
import com.tour.domain.UserRole;
import com.tour.repository.UserRepository;
import com.tour.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    // DataBase methods for user

    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    // Custom methods for User

    @Transactional
    public void add(User user) {
        userRepository.save(user);
        userRoleRepository.save(new UserRole(user.getId(), Role.USER.toString()));
    }
}
