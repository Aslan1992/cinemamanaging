package com.epam.cinema.dao;

import com.epam.cinema.domain.CinemaEvent;

import java.util.List;

public interface CinemaEventDao {
    void add(CinemaEvent cinemaEvent);
    List<CinemaEvent> getAllCinemaEvents();
}
