package com.babramowicz.dao;

import com.babramowicz.entities.Hospitals;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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

    @Override
    public void deleteHospitalById(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(session.get(Hospitals.class, id));

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateHospital(Integer id, String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        String update = "UPDATE Hospitals h SET h.name=:name, h.country=:country, h.town=:town, h.street=:street, h.postalCode=:postalCode, h.phoneNumber=:phoneNumber, h.faxNumber=:faxNumber, h.numberOfAmbulances=:numberOfAmbulances, h.helicopterAccess=:helicopterAccess, h.teachingHospital=:teachingHospital WHERE h.id=:id";
        Query query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter("name", name);
        query.setParameter("country", country);
        query.setParameter("town", town);
        query.setParameter("street", street);
        query.setParameter("postalCode", postalCode);
        query.setParameter("phoneNumber", phoneNumber);
        query.setParameter("faxNumber", faxNumber);
        query.setParameter("numberOfAmbulances", numberOfAmbulances);
        query.setParameter("helicopterAccess", helicopterAccess);
        query.setParameter("teachingHospital", teachingHospital);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Hospitals getHospitalById(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Hospitals hospital = session.get(Hospitals.class, id);

        session.getTransaction().commit();
        session.close();

        return hospital;
    }

    @Override
    public Hospitals getHospitalByName(String name) {
        Hospitals hospital;
        try {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            String select = "SELECT h from Hospitals h WHERE name=:name";
            Query query = session.createQuery(select);
            query.setParameter("name", name);
            hospital = (Hospitals) query.getSingleResult();
            session.getTransaction().commit();
            session.close();
            return hospital;
        } catch (NoResultException e) {
        }
        return null;
    }
}
