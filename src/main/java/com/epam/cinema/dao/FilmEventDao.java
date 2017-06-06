package com.epam.cinema.dao;

import com.epam.cinema.domain.FilmEvent;

import java.util.List;

public interface FilmEventDao {
    void add(FilmEvent filmEvent);
    List<FilmEvent> getAll();
    FilmEvent getById(Long id);
    void remove(Long id);
}
