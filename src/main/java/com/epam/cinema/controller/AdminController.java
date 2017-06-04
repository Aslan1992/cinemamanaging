package com.epam.cinema.controller;

import com.epam.cinema.service.CinemaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    private CinemaEventService cinemaEventService;

    @Autowired(required = true)
    @Qualifier(value = "cinemaEventService")
    public void setCinemaEventService(CinemaEventService cinemaEventService) {
        this.cinemaEventService = cinemaEventService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("gretting", "Administration page");
        model.addAttribute("cinemaEvents", cinemaEventService.getAllCinemaEvents());

        return "admin";
    }
}
