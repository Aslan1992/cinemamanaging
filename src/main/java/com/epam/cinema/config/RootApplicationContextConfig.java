package com.epam.cinema.config;

import com.epam.cinema.dao.EventDao;
import com.epam.cinema.dao.FilmDao;
import com.epam.cinema.dao.impl.EventDaoImpl;
import com.epam.cinema.dao.impl.FilmDaoImpl;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.FilmService;
import com.epam.cinema.service.impl.EventServiceImpl;
import com.epam.cinema.service.impl.FilmServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.epam.cinema")
public class RootApplicationContextConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/cinema_db");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.epam.cinema.domain"});
//        sessionFactory.setAnnotatedClasses(FilmEvent.class, FilmInfo.class);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public EventDao eventDao() {
        EventDaoImpl eventDao = new EventDaoImpl();
        eventDao.setSessionFactory(sessionFactory().getObject());
        return eventDao;
    }

    @Bean
    public EventService eventService() {
        EventServiceImpl eventService = new EventServiceImpl();
        eventService.setEventDao(eventDao());
        return eventService;
    }

    @Bean
    public FilmDao filmDao() {
        FilmDaoImpl filmDao = new FilmDaoImpl();
        filmDao.setSessionFactory(sessionFactory().getObject());
        return filmDao;
    }

    @Bean
    public FilmService filmService() {
        FilmServiceImpl filmService = new FilmServiceImpl();
        filmService.setFilmDao(filmDao());
        return filmService;
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.show_sql", "true");
            }
        };
    }


}
