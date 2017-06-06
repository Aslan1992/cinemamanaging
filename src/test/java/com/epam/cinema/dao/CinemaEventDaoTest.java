package com.epam.cinema.dao;

import com.epam.cinema.config.RootApplicationContextConfig;
import com.epam.cinema.dao.impl.FilmEventDaoImpl;
import com.epam.cinema.service.impl.FilmEventServiceImpl;
import org.junit.Test;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class CinemaEventDaoTest {

    @Test
    public void addDataToCinemaEvent() {
        RootApplicationContextConfig config = new RootApplicationContextConfig();
        LocalSessionFactoryBean sessionFactory = config.sessionFactory();
        FilmEventDaoImpl cinemaEventDao = new FilmEventDaoImpl();
        cinemaEventDao.setSessionFactory(sessionFactory.getObject());
        FilmEventServiceImpl service = new FilmEventServiceImpl();

    }
}
