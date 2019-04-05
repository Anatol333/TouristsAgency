package com.tour.controller;


import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getAdminData() {
        return "private";
    }

    @GetMapping("/test2")
    public String getNotPrivateData() {
        return "freePage";
    }

}
