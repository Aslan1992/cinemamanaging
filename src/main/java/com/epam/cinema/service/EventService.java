package com.epam.cinema.service;

import com.epam.cinema.domain.Event;

import java.util.List;

public interface EventService {
   void add(Event event);
   List<Event> getAll();
   Event getById(Long id);
   void remove(Long id);
}
