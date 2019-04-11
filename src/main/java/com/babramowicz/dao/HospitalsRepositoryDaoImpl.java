package com.babramowicz.dao;

import com.babramowicz.entities.Hospitals;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.List;

import static com.babramowicz.utils.HibernateUtil.getSessionFactory;

@Stateless
public class HospitalsRepositoryDaoImpl implements HospitalsRepositoryDao {

    @Override
    public List<Hospitals> getHospitalsList() {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        List<Hospitals> hospitalsList = session.createQuery("SELECT h FROM Hospitals h").getResultList();

        session.getTransaction().commit();
        session.close();

        return hospitalsList;
    }

    @Override
    public Hospitals addNewHospital(Hospitals hospital) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.save(hospital);

        session.getTransaction().commit();
        session.close();

        return hospital;
    }
}
