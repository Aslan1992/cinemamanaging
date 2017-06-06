package com.epam.cinema.controller;

import com.epam.cinema.domain.FilmEvent;
import com.epam.cinema.domain.util.LocalDateEditor;
import com.epam.cinema.domain.util.LocalTimeEditor;
import com.epam.cinema.service.FilmEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private FilmEventService filmEventService;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, "day", new LocalDateEditor());
        binder.registerCustomEditor(LocalTime.class, "time", new LocalTimeEditor());
    }

    @Autowired(required = true)
    @Qualifier(value = "filmEventService")
    public void setFilmEventService(FilmEventService filmEventService) {
        this.filmEventService = filmEventService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("gretting", "Administration page");
        model.addAttribute("filmEvents", filmEventService.getAll());
        model.addAttribute("filmEvent", new FilmEvent());
        return "admin";
    }

    @RequestMapping(value = "/admin/addNewEvent", method = RequestMethod.POST)
    public String addNewEvent(@ModelAttribute("filmEvent") FilmEvent filmEvent) {
        filmEventService.add(filmEvent);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/getEventById", method = RequestMethod.GET)
    public String getEventById(@RequestParam Long eventId, Model model) {
        List<FilmEvent> filmEvents = new ArrayList<>();
        if (eventId != null) {
            filmEvents.add(filmEventService.getById(eventId));
            model.addAttribute("filmEvents", filmEvents);
            model.addAttribute("filmEvent", new FilmEvent());
        }
        return "admin";
    }

    @RequestMapping("/admin/remove/{id}")
    public String removeEventById(@PathVariable Long id) {
        filmEventService.remove(id);
        return "redirect:/admin";
    }
}
