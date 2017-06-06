package com.epam.cinema.service;

import com.epam.cinema.domain.FilmEvent;

import java.util.List;

public interface FilmEventService {
   void add(FilmEvent filmEvent);
   List<FilmEvent> getAll();
   FilmEvent getById(Long id);
   void remove(Long id);
}
