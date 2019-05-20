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

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class AdminController {

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

//    @Autowired
//    private CityTourRepository cityTourRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    // For admin pages

    @GetMapping("/admin")
    public String getAdminData(Model model) {
        // Adding/Update User Role
        model.addAttribute("user_role", new UserRole());
        model.addAttribute("roles", Stream.of(Role.values())
                .map(Role::name)
                .collect(Collectors.toList()));
        // Adding country
        model.addAttribute("country", new Country());
        // Adding city
        model.addAttribute("city", new City());
        model.addAttribute("list", countryRepository.findAll());
        // Adding sight
        model.addAttribute("sight", new Sight());
        model.addAttribute("list_city", cityRepository.findAll());
        // Adding Tour
        model.addAttribute("tour", new Tour());
        // Adding Tour Content
        model.addAttribute("tour_content", new Tour_Content());
        model.addAttribute("list_tour", tourRepository.findAll());
        // Adding City Tour
        //model.addAttribute("city_tour", new City_Tour());
        //model.addAttribute("list_sight", sightRepository.findAll());
        // Adding Hotel
        model.addAttribute("hotel", new Hotel());
        // Adding Room
        model.addAttribute("room", new Room());
        model.addAttribute("list_hotel", hotelRepository.findAll());
        model.addAttribute("list_type", roomTypeRepository.findAll());
        // Adding Room Type
        model.addAttribute("room_type", new Room_Type());
        // Adding Services
        model.addAttribute("services", new Services());
        // Adding Room Service
        model.addAttribute("room_service", new Room_Service());
        model.addAttribute("list_room", roomRepository.findAll());
        model.addAttribute("list_service", servicesRepository.findAll());

        return "private";
    }


    // Admin redirect pages
    @PostMapping("/admin/userrole")
    public String saveUserRole(@ModelAttribute UserRole userRole) {
        if (userRoleRepository.findById(userRole.getUser_id()).get().getRoles() != userRole.getRoles()) {
            userRoleRepository.save(userRole);
        }
        return "redirect:/admin";
    }

    @PostMapping("/admin/country")
    public String saveCountry(@ModelAttribute Country country) {
        countryRepository.save(country);
        return "redirect:/admin";
    }

    @PostMapping("/admin/city")
    public String saveCity(@ModelAttribute City city) {
        cityRepository.save(city);
        return "redirect:/admin";
    }

    @PostMapping("/admin/sight")
    public String saveSight(@ModelAttribute Sight sight) {
        sightRepository.save(sight);
        return "redirect:/admin";
    }

    @PostMapping("/admin/tour")
    public String saveTour(@ModelAttribute Tour tour) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(new Date());
        Date date = format.parse(tour.getDate_Start());
        tourRepository.save(tour);
        return "redirect:/admin";
    }

    @PostMapping("/admin/tour_content")
    public String saveTourContent(@ModelAttribute Tour_Content tourContent) {
        tourContentRepository.save(tourContent);
        return "redirect:/admin";
    }
//
//    @PostMapping("/admin/city_tour")
//    public String saveCityTour(@ModelAttribute City_Tour city_tour) {
//        cityTourRepository.save(city_tour);
//        return "redirect:/admin";
//    }

    @PostMapping("/admin/hotel")
    public String saveHotel(@ModelAttribute Hotel hotel) {
        hotelRepository.save(hotel);
        return "redirect:/admin";
    }

    @PostMapping("/admin/roomtype")
    public String saveRoomType(@ModelAttribute Room_Type roomType) {
        roomTypeRepository.save(roomType);
        return "redirect:/admin";
    }

    @PostMapping("/admin/room")
    public String saveRoomType(@ModelAttribute Room room) {
        roomRepository.save(room);
        return "redirect:/admin";
    }

    @PostMapping("/admin/services")
    public String saveServices(@ModelAttribute Services services) {
        servicesRepository.save(services);
        return "redirect:/admin";
    }

    @PostMapping("/admin/room_services")
    public String saveServices(@ModelAttribute Room_Service room_service) {
        roomServiceRepository.save(room_service);
        return "redirect:/admin";
    }
}
