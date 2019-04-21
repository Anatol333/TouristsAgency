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

    @GetMapping("/admin")
    public String getAdminData(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("city", new City());
        model.addAttribute("list",countryRepository.findAll());
        return "private";
    }
//    @PostMapping("/admin")
//    public String postAdminData(
//            @ModelAttribute("city") City city, BindingResult cityResult,
//            @ModelAttribute("country") Country country, BindingResult countryResult
//    ) {
//        if(!cityResult.hasErrors() && city != null)
//            cityRepository.save(city);
//        if(!countryResult.hasErrors() && country != null)
//            countryRepository.save(country);
//        return "redirect:/admin";
//    }

    @PostMapping("/admin/country")
    public String saveCountry(@ModelAttribute Country country) {
        countryRepository.save(country);
        return "redirect:/admin";
    }
    @PostMapping("/admin/city")
    public String saveCountry(@ModelAttribute City city) {
        cityRepository.save(city);
        return "redirect:/admin";
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
