package com.epam.cinema.service.impl;

import com.epam.cinema.dao.EventDao;
import com.epam.cinema.domain.Event;
import com.epam.cinema.service.EventService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    @Transactional
    public void add(Event event) {
        this.eventDao.add(event);
    }

    @Override
    @Transactional
    public List<Event> getAll() {
        return this.eventDao.getAll();
    }

    @Override
    @Transactional
    public Event getById(Long id) {
        return this.eventDao.getById(id);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        this.eventDao.remove(id);
    }
}
