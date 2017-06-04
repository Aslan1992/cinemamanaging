package com.epam.cinema.service.impl;

import com.epam.cinema.dao.CinemaEventDao;
import com.epam.cinema.domain.CinemaEvent;
import com.epam.cinema.service.CinemaEventService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CinemaEventServiceImpl implements CinemaEventService {

    private CinemaEventDao cinemaEventDao;

    public void setCinemaEventDao(CinemaEventDao cinemaEventDao) {
        this.cinemaEventDao = cinemaEventDao;
    }

    @Override
    @Transactional
    public void add(CinemaEvent cinemaEvent) {
        cinemaEventDao.add(cinemaEvent);
    }

    @Override
    @Transactional
    public List<CinemaEvent> getAllCinemaEvents() {
        return cinemaEventDao.getAllCinemaEvents();
    }
}
