package com.epam.cinema.controller;

import com.epam.cinema.domain.Event;
import com.epam.cinema.domain.util.LocalDateEditor;
import com.epam.cinema.domain.util.LocalTimeEditor;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private EventService eventService;

    private FilmService filmService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, "day", new LocalDateEditor());
        binder.registerCustomEditor(LocalTime.class, "time", new LocalTimeEditor());
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("events", eventService.getAll());
        model.addAttribute("films", filmService.getAll());
        model.addAttribute("event", new Event());
        return "admin";
    }

    @RequestMapping(value = "/admin/addNewEvent", method = RequestMethod.POST)
    public String addNewEvent(@ModelAttribute("event") Event event) {
        eventService.add(event);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/getEventById", method = RequestMethod.GET)
    public String getEventById(@RequestParam Long eventId, Model model) {
        List<Event> filmEvents = new ArrayList<>();
        if (eventId != null) {
            filmEvents.add(eventService.getById(eventId));
            model.addAttribute("events", filmEvents);
            model.addAttribute("event", new Event());
        }
        return "admin";
    }

    @RequestMapping("/admin/remove/{id}")
    public String removeEventById(@PathVariable Long id) {
        eventService.remove(id);
        return "redirect:/admin";
    }
}
