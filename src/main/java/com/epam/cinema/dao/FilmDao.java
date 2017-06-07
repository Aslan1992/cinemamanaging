package com.epam.cinema.dao;

import com.epam.cinema.domain.Film;

import java.util.List;

public interface FilmDao {
    List<Film> getAll();
}
