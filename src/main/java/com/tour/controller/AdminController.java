package com.tour.controller;

import com.tour.domain.*;
import com.tour.repository.*;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private SightRepository sightRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourContentRepository tourContentRepository;

    // For admin pages

    @GetMapping("/admin")
    public String getAdminData(Model model) {
        // Adding country
        model.addAttribute("country", new Country());
        // Adding city
        model.addAttribute("city", new City());
        model.addAttribute("list", countryRepository.findAll());
        // Adding sight
        model.addAttribute("sight",new Sight());
        model.addAttribute("list_city", cityRepository.findAll());
        // Adding Tour
        model.addAttribute("tour", new Tour());
        // Adding Tour Content
        model.addAttribute("tour_content", new Tour_Content());
        model.addAttribute("list_tour", tourRepository.findAll());

        return "private";
    }

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

    @PostMapping("/admin/sight")
    public String saveCountry(@ModelAttribute Sight sight) {
        sightRepository.save(sight);
        return "redirect:/admin";
    }

    @PostMapping("/admin/tour")
    public String saveCountry(@ModelAttribute Tour tour) {
        tourRepository.save(tour);
        return "redirect:/admin";
    }

    @PostMapping("/admin/tour_content")
    public String saveCountry(@ModelAttribute Tour_Content tourContent) {
        tourContentRepository.save(tourContent);
        return "redirect:/admin";
    }
}
