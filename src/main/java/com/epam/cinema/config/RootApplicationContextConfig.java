package com.epam.cinema.config;

import com.epam.cinema.dao.FilmEventDao;
import com.epam.cinema.dao.impl.FilmEventDaoImpl;
import com.epam.cinema.domain.FilmEvent;
import com.epam.cinema.service.FilmEventService;
import com.epam.cinema.service.impl.FilmEventServiceImpl;
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
//        sessionFactory.setPackagesToScan(new String[]{"com.epam.cinema.domain"});
        sessionFactory.setAnnotatedClasses(FilmEvent.class);
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
    public FilmEventDao filmEventDao() {
        FilmEventDaoImpl filmEventDao = new FilmEventDaoImpl();
        filmEventDao.setSessionFactory(sessionFactory().getObject());
        return filmEventDao;
    }

    @Bean
    public FilmEventService filmEventService() {
        FilmEventServiceImpl filmEventService = new FilmEventServiceImpl();
        filmEventService.setFilmEventDao(filmEventDao());
        return filmEventService;
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
