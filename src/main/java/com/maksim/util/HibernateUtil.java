package com.maksim.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        sessionFactory = cfg.buildSessionFactory(builder);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
