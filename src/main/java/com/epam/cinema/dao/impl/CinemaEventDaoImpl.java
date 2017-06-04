package com.epam.cinema.dao.impl;

import com.epam.cinema.dao.CinemaEventDao;
import com.epam.cinema.domain.CinemaEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaEventDaoImpl implements CinemaEventDao {
//    private static final Logger logger = Logger.getLogger(CinemaEventDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CinemaEvent cinemaEvent) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cinemaEvent);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CinemaEvent> getAllCinemaEvents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CinemaEvent> cinemaEventList = session.createQuery("from CinemaEvent").list();

        for(CinemaEvent cinemaEvent : cinemaEventList) {
//            logger.info("Cinema event: " + cinemaEvent);
        }

        return cinemaEventList;
    }
}
