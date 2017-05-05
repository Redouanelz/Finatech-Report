package com.example;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.model.*;

public class HibernateUtil {
	

        private static SessionFactory sessionFactory;
        private static ServiceRegistry serviceRegistry;
        static {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Consumption.class);
                configuration.addAnnotatedClass(Meter.class);
                configuration.addAnnotatedClass(Validity.class);
                configuration.addAnnotatedClass(Parameter.class);
                serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                System.out.println(e);
            }
        }

        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }



}
