package com.tour.controller;

import com.tour.domain.*;
import com.tour.domain.dto.CheckDTO;
import com.tour.repository.*;
import com.tour.service.UserService;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class TourController {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TourContentRepository tourContentRepository;

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    @Autowired
    private SightRepository sightRepository;

    @Autowired
    private Custom_CheckRepository custom_checkRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTourCheckRepository userTourCheckRepository;

    @Autowired
    private SightCustomCheckRepository sightCustomCheckRepository;

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
                               Authentication authentication,
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
        model.addAttribute("rooms", roomServiceRepository.getJustRoomInfo(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("service", roomServiceRepository.getFullRoomInfoPrice(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("user", userService.loadUserByUsername(
                authentication.getName()
        ));
        model.addAttribute("tour", tourRepository.findOneTourID(id));
        model.addAttribute("custom_check", new CheckDTO());
        model.addAttribute("sights", sightRepository.getListSightForTour(id));

        return "tour/checkout";
    }


    @PostMapping("/buy/tour/ordering/{id}")
    public String checkGetPost(@ModelAttribute CheckDTO checkDTO,
                               Authentication authentication,
                               @PathVariable("id") Integer id) {

        // Get info about user
        User user = userRepository.findOneBID(
                userService.loadUserByUsername(
                        authentication.getName()
                ).getUsername()
        );

        // User Main Check (Main custom info about user tour)
        Integer price = tourRepository.findOneTourID(id).getPrice();
        Pattern p = Pattern.compile("((.*?);(.*?);(.*?);)");
        for (String service : checkDTO.getID_Service()) {
            Matcher m = p.matcher(service);
            while (m.find()) {
                price += roomServiceRepository.getPriceServiceByID(
                        Integer.parseInt(m.group(4))
                );
                price += roomServiceRepository.getPriceRoomByID(
                        Integer.parseInt(m.group(3))
                );
            }
        }
        for (Integer idSight : checkDTO.getID_Sight()) {
            price += roomServiceRepository.getPriceSightByID(idSight);
        }
        custom_checkRepository.save(new Custom_Check(id,
                        user.getId(),
                        checkDTO.getCustom_Date_Start(),
                        checkDTO.getCustom_Date_End(),
                        price.toString()
                )
        );

        // Save info about Service
        if (checkDTO.getID_Sight() != null) {
            for (int i = 0; i < checkDTO.getID_Sight().size(); ++i) {
                // to Console
                System.out.println(checkDTO.getID_Sight().get(i) + " "
                        + id + " " + user.getId());
                // to Data Base
                sightCustomCheckRepository.save(new Sight_Custom_Check(
                        checkDTO.getID_Sight().get(i), id, user.getId()
                ));
            }
        }

        // Not parsed
        System.out.println(checkDTO.getID_Service());
        //Parsed
        //p = Pattern.compile("((.*?);(.*?);(.*?);)");
        for (String service : checkDTO.getID_Service()) {
            Matcher m = p.matcher(service);
            while (m.find()) {
                // Console Output
                System.out.println("Hotel: " + m.group(2)
                        + ", Room : " + m.group(3)
                        + ", Service: " + m.group(4));
                // DataBase Output
                userTourCheckRepository.save(
                        new User_Tour_Check(
                                Integer.parseInt(m.group(3)),
                                Integer.parseInt(m.group(4)),
                                Integer.parseInt(m.group(2)),
                                id,
                                user.getId()
                        )
                );
            }
        }
        return "redirect:/acc";
    }


}
