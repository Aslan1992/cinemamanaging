package com.epam.cinema.dao.impl;

import com.epam.cinema.dao.EventDao;
import com.epam.cinema.domain.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    private static final Logger logger = LoggerFactory.getLogger(EventDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Event event) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(event);
        logger.info("Event successfully added: " + event);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Event> events = session.createQuery("from Event").list();
        return events;
    }

    @Override
    public Event getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event event = (Event) session.get(Event.class, id);
        if (event == null) {
            logger.info("Could find event with current id: " + id);
        }
        return event;
    }

    @Override
    public void remove(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event event = (Event) session.get(Event.class, id);
        if (event != null) {
            session.delete(event);
            logger.info("Event successfully removed. Event details: " + event);
        }
    }
}
