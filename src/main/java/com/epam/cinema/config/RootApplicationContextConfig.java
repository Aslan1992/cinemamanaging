package com.epam.cinema.config;

import com.epam.cinema.dao.CinemaEventDao;
import com.epam.cinema.dao.impl.CinemaEventDaoImpl;
import com.epam.cinema.domain.CinemaEvent;
import com.epam.cinema.service.CinemaEventService;
import com.epam.cinema.service.impl.CinemaEventServiceImpl;
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
        sessionFactory.setAnnotatedClasses(CinemaEvent.class);
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
    public CinemaEventDao cinemaEventDao() {
        CinemaEventDaoImpl cinemaEventDao = new CinemaEventDaoImpl();
        cinemaEventDao.setSessionFactory(sessionFactory().getObject());
        return cinemaEventDao;
    }

    @Bean
    public CinemaEventService cinemaEventService() {
        CinemaEventServiceImpl cinemaEventService = new CinemaEventServiceImpl();
        cinemaEventService.setCinemaEventDao(cinemaEventDao());
        return cinemaEventService;
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
