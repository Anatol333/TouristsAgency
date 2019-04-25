package com.tour.controller;

import com.tour.domain.Tour;
import com.tour.domain.embeddable.EmbTour_Content;
import com.tour.repository.TourContentRepository;
import com.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class TourController {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourContentRepository tourContentRepository;

    @GetMapping("/buy")
    public String getBuyPage(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");

        Integer price = 0;
        model.addAttribute("filter_price", price);
        model.addAttribute("tour", tourRepository.findAll());
        model.addAttribute("tour_content", tourContentRepository.findAll());

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

        model.addAttribute("filter_price", price);
        model.addAttribute("depcity", depcity);
        model.addAttribute("tour", tourRepository.customfind(price));
        model.addAttribute("tour_content", tourContentRepository.findCityCustomName(depcity));

        return "tour/buy";
    }

    @PostMapping("/buy/filter")
    public String searchByFilter(@ModelAttribute Integer price) {
        return "redirect:/buy/"+price;
    }
}
