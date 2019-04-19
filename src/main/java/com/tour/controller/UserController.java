package com.tour.controller;


import com.tour.domain.User;
import com.tour.repository.UserRepository;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String getAdminData() {
        return "private";
    }

    @GetMapping("/test2")
    public String getNotPrivateData() {
        return "freePage";
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public String getUserData(@PathVariable(value = "id") Integer userId, Model model) {
        User user = userService.loadUserById(userId);
        model.addAttribute("id", user.getId().toString());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("user",user);
        return "user/account";
    }

}
