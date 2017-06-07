package com.epam.cinema.dao;

import com.epam.cinema.config.RootApplicationContextConfig;
import com.epam.cinema.dao.impl.EventDaoImpl;
import com.epam.cinema.service.impl.EventServiceImpl;
import org.junit.Test;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class CinemaEventDaoTest {

    @Test
    public void addDataToCinemaEvent() {
        RootApplicationContextConfig config = new RootApplicationContextConfig();
        LocalSessionFactoryBean sessionFactory = config.sessionFactory();
        EventDaoImpl cinemaEventDao = new EventDaoImpl();
        cinemaEventDao.setSessionFactory(sessionFactory.getObject());
        EventServiceImpl service = new EventServiceImpl();

    }
}
