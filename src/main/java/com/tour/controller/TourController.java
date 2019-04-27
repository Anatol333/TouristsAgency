package com.tour.controller;

import com.tour.repository.CityRepository;
import com.tour.repository.TourContentRepository;
import com.tour.repository.TourRepository;
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
import java.util.List;

@Controller
public class TourController {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourContentRepository tourContentRepository;

    @Autowired
    private CityRepository cityRepository;




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
//    @GetMapping("/buy/{price}")
    public String getBuyPage(@PathVariable("price") Integer price,
                             @PathVariable("depcity") String depcity,
                             Model model,
                             HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("authButton",
                principal != null ? "ACCOUNT" : "SIGN IN");

        if(price == 0) price = Integer.MAX_VALUE;
        model.addAttribute("filter_price", price);
        if(depcity.equals("null")) {
            model.addAttribute("filter_price", price);
            model.addAttribute("tour", tourRepository.customfind(price));
        } else {
            model.addAttribute("filter_price", price);
            model.addAttribute("depcity", depcity);
            model.addAttribute("tour", tourRepository.findTourInCity(depcity,price));
           // model.addAttribute("tour_content", tourRepository.findTourInCity(depcity));
        }
//        //model.addAttribute("depcity", depcity);
//        model.addAttribute("tour", tourRepository.customfind(price));
//        //model.addAttribute("tour_content", tourContentRepository.getListTourContentByName(depcity));

        return "tour/buy";
    }

}
