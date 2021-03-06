package com.iljaust.util;

import com.iljaust.model.Account;
import com.iljaust.model.AccountStatus;
import com.iljaust.model.Developer;
import com.iljaust.model.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;



public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.URL, "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_3200fdebdafe424");
                settings.put(Environment.USER, "bb8d4bdfd28335");
                settings.put(Environment.PASS, "9f61ac76");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57InnoDBDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Skill.class);
                configuration.addAnnotatedClass(Developer.class);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(AccountStatus.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}