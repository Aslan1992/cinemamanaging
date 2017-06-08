package com.epam.cinema.dao.impl;

import com.epam.cinema.dao.FilmDao;
import com.epam.cinema.domain.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDaoImpl implements FilmDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Film> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Film> filmInfos = session.createQuery("from Film").list();
        return filmInfos;
    }

    @Override
    public void add(Film film) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(film);
    }
}
