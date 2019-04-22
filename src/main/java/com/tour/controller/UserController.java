package com.tour.controller;


import com.tour.domain.City;
import com.tour.domain.Country;
import com.tour.domain.User;
import com.tour.repository.CityRepository;
import com.tour.repository.CountryRepository;
import com.tour.repository.UserRepository;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;


    @GetMapping("/acc")
    public String getAcc(Model model, Authentication authentication) {
        model.addAttribute("user", userService.loadUserByUsername(
                authentication.getName()
        ));
        return "user/acc";
    }


    // Testing pages ...

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
