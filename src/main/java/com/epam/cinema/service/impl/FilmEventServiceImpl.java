package com.epam.cinema.service.impl;

import com.epam.cinema.dao.FilmEventDao;
import com.epam.cinema.domain.FilmEvent;
import com.epam.cinema.service.FilmEventService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmEventServiceImpl implements FilmEventService {

    private FilmEventDao filmEventDao;

    public void setFilmEventDao(FilmEventDao filmEventDao) {
        this.filmEventDao = filmEventDao;
    }

    @Override
    @Transactional
    public void add(FilmEvent filmEvent) {
        this.filmEventDao.add(filmEvent);
    }

    @Override
    @Transactional
    public List<FilmEvent> getAll() {
        return this.filmEventDao.getAll();
    }

    @Override
    @Transactional
    public FilmEvent getById(Long id) {
        return this.filmEventDao.getById(id);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        this.filmEventDao.remove(id);
    }
}
