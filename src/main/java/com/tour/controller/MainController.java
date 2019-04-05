package com.tour.controller;

import com.tour.domain.User;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMain(@RequestParam(name = "name", required = false, defaultValue = "World")
                                  String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/test1")
    public String getTest1(Model model) {
        model.addAttribute("users", userService.getAll());
        return "freemark";
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
