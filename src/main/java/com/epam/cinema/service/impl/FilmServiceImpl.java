package com.epam.cinema.service.impl;

import com.epam.cinema.dao.FilmDao;
import com.epam.cinema.domain.Film;
import com.epam.cinema.service.FilmService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmDao filmDao;

    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    @Transactional
    public List<Film> getAll() {
        return filmDao.getAll();
    }
}
