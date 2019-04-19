package com.tour.controller;

import com.tour.domain.User;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    private Authentication authentication;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMain(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");
        return "main/index";
    }

    @GetMapping("/test1")
    public String getTest1(Model model, Authentication authentication) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("authUser", authentication.getName());
        return "test1";
    }

    // Authentication Controllers
    @GetMapping("/auth")
    public String getAuth(Model model) {
        model.addAttribute("authButton", "SIGN IN");
        model.addAttribute("user", new User());
        return "main/auth";
    }
    @PostMapping("/auth")
    public String setAuth(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("authButton", "SIGN IN");
        return "main/login";
    }


    @GetMapping("/about")
    public String getAbout() {
        return "main/about";
    }
}
