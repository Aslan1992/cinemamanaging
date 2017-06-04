package com.epam.cinema.service;

import com.epam.cinema.domain.CinemaEvent;

import java.util.List;

public interface CinemaEventService {
   void add(CinemaEvent cinemaEvent);
   List<CinemaEvent> getAllCinemaEvents();
}
