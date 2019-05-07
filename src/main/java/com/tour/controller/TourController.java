package com.tour.controller;

import com.tour.domain.Custom_Check;
import com.tour.domain.Sight_Custom_Check;
import com.tour.domain.User;
import com.tour.domain.User_Tour_Check;
import com.tour.domain.dto.CheckDTO;
import com.tour.repository.*;
import com.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
//
//    @Autowired
//    private CustomCityListRepository customCityListRepository;

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
        model.addAttribute("rooms", roomServiceRepository.getFullHotelInfo(
                tourContentRepository.getListCityTourContentById(id)
        ));
        model.addAttribute("service", roomServiceRepository.getFullRoomInfo(
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
        custom_checkRepository.save(new Custom_Check(id,
                        user.getId(),
                        checkDTO.getCustom_Date_Start(),
                        checkDTO.getCustom_Date_End(),
                        tourRepository.findOneTourID(id).getPrice().toString()
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

        if (checkDTO.getID_Hotel() != null) {
            for (int i = 0; i < checkDTO.getID_Hotel().size(); ++i) {
                for (int j = 0; j < checkDTO.getID_Room().size(); ++j) {
                    int service = 0;
                    int serviceNext = 0;
                    if (isInList(checkDTO.getID_Room().get(j),
                            userTourCheckRepository.findListHotelByID(i + 1)))
//                        {
//                            if (checkDTO.getID_Room() != null) {
//                                for (int k = 0; k < checkDTO.getID_Service().size(); ++k) {
//                                    if (isInList(checkDTO.getID_Service().get(k),
//                                            userTourCheckRepository.findListServiceByID(
//                                                    checkDTO.getID_Room().get(j)
//                                            ))
//                                    ) {
//                                        // console Output
//                                        System.out.println(checkDTO.getID_Hotel().get(i) + " "
//                                                + checkDTO.getID_Room().get(j) + " "
//                                                + checkDTO.getID_Service().get(k));
//                                    }
//                                }
//                            }
//                        }
                        for (int k = 0; k < checkDTO.getID_Service().size(); ++k) {
                            if (checkDTO.getID_Service().get(k).equals(checkDTO.getID_Service().get(j))) {
                                service = checkDTO.getID_Service().get(k);
                                if (service != serviceNext) {
                                    // Out data to console
                                    System.out.println(checkDTO.getID_Hotel().get(i) +
                                            " - " + checkDTO.getID_Room().get(j) +
                                            " - " + checkDTO.getID_Service().get(k));
                                    // Out data to db
                                    userTourCheckRepository.save(
                                            new User_Tour_Check(
                                                    checkDTO.getID_Room().get(j),
                                                    checkDTO.getID_Service().get(k),
                                                    checkDTO.getID_Hotel().get(i),
                                                    id,
                                                    user.getId()
                                            )
                                    );
                                }
                                serviceNext = checkDTO.getID_Service().get(k);
                            }

                        }
                }
            }

//        // User Check (Middle table with info about hotel and service)
//        Integer mainIdStart = userTourCheckRepository.findAll().size() + 1;
//        Integer mainID = userTourCheckRepository.findAll().size() + 1;
//
//        for (int i = 0; i < checkDTO.getID_Hotel().size(); ++i) {
//            for (int j = 0; j < checkDTO.getID_Room().size(); ++j) {
//                int service;
//                int serviceNext = 0;
//                if (checkDTO.getID_Room().get(i).equals(checkDTO.getID_Room().get(j))) {
////                 if (checkDTO.getID_Room().get(i).equals(checkDTO.getID_Room().get(j))) {
////                if (checkDTO.getID_Room().get(j) != null) {
//                    for (int k = 0; k < checkDTO.getID_Service().size(); ++k) {
//                        if (checkDTO.getID_Service().get(k).equals(checkDTO.getID_Service().get(j))) {
//                            service = checkDTO.getID_Service().get(k);
//                            if (service != serviceNext) {
//                                // Out data to console
//                                System.out.println(checkDTO.getID_Hotel().get(i) +
//                                        " - " + checkDTO.getID_Room().get(j) +
//                                        " - " + checkDTO.getID_Service().get(k));
//                                // Save Data to repository
////                                userTourCheckRepository.save(
////                                        new User_Tour_Check(
////                                                mainID,
////                                                checkDTO.getID_Room().get(j),
////                                                checkDTO.getID_Service().get(k),
////                                                checkDTO.getID_Hotel().get(i),
////                                                id,
////                                                user.getId()
////                                        )
////                                );
////                                mainID++;
//                            }
//                            serviceNext = checkDTO.getID_Service().get(k);
//                        }
//                    }
//                }
//            }
//        }
//        List<Integer> ctList = customCityListRepository.getListCityForUser(checkDTO.getID_Sight());
//        // Custom User Sights from Tour (Last Table) "Custom City List"
//        for (int i = mainIdStart; i < mainID; ++i) {
//            for (int j = 0; j < ctList.size(); ++j) {
//                customCityListRepository.save(new Custom_City_List(
//                                i,
//                                ctList.get(j),
//                                id,
//                                user.getId()
//                        )
//                );
//               //System.out.println(id + " - " + i + " - " + ctList.get(j));
//            }
//        }
        }

        return "redirect:/acc";
    }


    // Check for room
    private boolean isInList(int ID_Room, List<Integer> roomHotel) {
        for (int i = 0; i < roomHotel.size(); ++i) {
            if (roomHotel.get(i) == ID_Room) {
                return true;
            }
        }
        return false;
    }

    // Check for services
    private boolean isInRoom(Integer ID_Service, Integer room) {
        if (userTourCheckRepository.findFignya(ID_Service, room) != null) {
            return userTourCheckRepository.findFignya(ID_Service, room).equals(ID_Service);
        }
        return false;
    }

}
