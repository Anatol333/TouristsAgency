package com.tour.controller;

import com.tour.domain.City_Tour;
import com.tour.domain.Custom_Check;
import com.tour.domain.dto.CheckDTO;
import com.tour.domain.dto.TourDTO;
import com.tour.repository.*;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TourController {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourContentRepository tourContentRepository;

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    @Autowired
    private SightRepository sightRepository;


    @GetMapping("/buy")
    public String getBuyPage(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");

        Integer price = 0;
        model.addAttribute("filter_price", price);
        model.addAttribute("tour", tourRepository.findAll());
        model.addAttribute("tour_content", tourContentRepository.getListTourContentAll());

        return "tour/buy";
    }

    @GetMapping("/buy/{price}/{depcity}")
    public String getBuyPage(@PathVariable("price") Integer price,
                             @PathVariable("depcity") String depcity,
                             Model model,
                             HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");

        if (price == 0) price = Integer.MAX_VALUE;
        model.addAttribute("filter_price", price);
        if (depcity.equals("null")) {
            model.addAttribute("filter_price", price);
            model.addAttribute("tour", tourRepository.customfind(price));
        } else {
            model.addAttribute("filter_price", price);
            model.addAttribute("depcity", depcity);
            model.addAttribute("tour", tourRepository.findTourInCity(depcity, price));
            // model.addAttribute("tour_content", tourRepository.findTourInCity(depcity));
        }
        return "tour/buy";
    }

    @GetMapping("/buy/tour/{id}")
    public String getOneTour(@PathVariable("id") Integer id,
                             Model model,
                             HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");

        model.addAttribute("tour", tourRepository.findOneTourID(id));
        model.addAttribute("sight", sightRepository.getListSightForTour(id));

        return "tour/tour";
    }

    @GetMapping("/buy/tour/{id}/checkout")
    public String checkoutTour(@PathVariable("id") Integer id,
                               Model model,
                               HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");

        model.addAttribute("just_hotel", roomServiceRepository.getJustHotelInfo(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("hotels", roomServiceRepository.getFullHotelInfo(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("rooms", roomServiceRepository.getFullHotelInfo(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("service", roomServiceRepository.getFullRoomInfo(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("tour", tourRepository.findOneTourID(id));
        model.addAttribute("custom_check", new CheckDTO());
        model.addAttribute("sights", sightRepository.getListSightForTour(id));

        return "tour/checkout";
    }


    @PostMapping("/buy/tour/ordering")
    public String checkGetPost(@ModelAttribute CheckDTO checkDTO) {

        System.out.println(checkDTO.getID_Sight().toString());

        return "redirect:/";
    }

}
