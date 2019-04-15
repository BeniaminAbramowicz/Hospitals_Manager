package com.babramowicz.utils;

import com.babramowicz.entities.Doctors;
import com.babramowicz.entities.Hospitals;
import com.babramowicz.entities.HospitalDoctors;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            Configuration conf = new Configuration();
            conf.configure("hibernate.cfg.xml");
            conf.addAnnotatedClass(Hospitals.class);
            conf.addAnnotatedClass(Doctors.class);
            conf.addAnnotatedClass(HospitalDoctors.class);
            SessionFactory sessionFactory = conf.buildSessionFactory();
            return sessionFactory;
        } catch (Throwable e){
            System.err.println("Session factory creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
