package com.epam.cinema.dao.impl;

import com.epam.cinema.dao.FilmEventDao;
import com.epam.cinema.domain.FilmEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmEventDaoImpl implements FilmEventDao {
    private static final Logger logger = LoggerFactory.getLogger(FilmEventDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(FilmEvent filmEvent) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(filmEvent);
        logger.info("Film event successfully added: " + filmEvent);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FilmEvent> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FilmEvent> filmEventList = session.createQuery("from FilmEvent").list();
        return filmEventList;
    }

    @Override
    public FilmEvent getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        FilmEvent filmEvent = (FilmEvent) session.get(FilmEvent.class, id);
        if (filmEvent == null) {
            logger.info("Could find film event with current id: " + id);
        }
        return filmEvent;
    }

    @Override
    public void remove(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        FilmEvent filmEvent = (FilmEvent) session.get(FilmEvent.class, id);
        if (filmEvent != null) {
            session.delete(filmEvent);
            logger.info("Film event successfully removed. Cinema event details: " + filmEvent);
        }
    }
}
