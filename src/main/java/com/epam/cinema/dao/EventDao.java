package com.epam.cinema.dao;

import com.epam.cinema.domain.Event;

import java.util.List;

public interface EventDao {
    void add(Event event);
    List<Event> getAll();
    Event getById(Long id);
    void remove(Long id);
}
