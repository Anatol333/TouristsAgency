package com.tour.controller;

import com.tour.domain.Role;
import com.tour.domain.User;
import com.tour.domain.UserRole;
import com.tour.repository.UserRoleRepository;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @RequestMapping("/")
    public String getMain() {
        return "index";
    }

    @GetMapping("/test1")
    public String getTest1(Model model, Authentication authentication) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("authUser", authentication.getName());
        return "test1";
    }

    @GetMapping("/auth")
    public String getAuth(Model model) {
        model.addAttribute("user", new User());
        return "auth";
    }

    @PostMapping("/auth")
    public String setAuth(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/";
    }

}
