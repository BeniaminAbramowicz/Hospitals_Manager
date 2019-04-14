package com.babramowicz.dao;


import com.babramowicz.entities.Doctors;
import org.hibernate.Session;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

import static com.babramowicz.utils.HibernateUtil.getSessionFactory;

@Stateless
public class DoctorsRepositoryDaoImpl implements DoctorsRepositoryDao{

    @Override
    public Doctors getDoctorById(int id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Doctors doctor = session.get(Doctors.class, id);

        session.getTransaction().commit();
        session.close();

        return doctor;
    }

    @Override
    public Doctors getDoctorByLicenseNumber(String licenseNumber) {

        Doctors doctor;
        try {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            String select = "SELECT d from Doctors d WHERE licenseNumber=:licenseNumber";
            Query query = session.createQuery(select);
            query.setParameter("licenseNumber", licenseNumber);
            doctor = (Doctors) query.getSingleResult();
            session.getTransaction().commit();
            session.close();
            return doctor;
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public List<Doctors> getDoctorsList() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        List<Doctors> doctorsList = session.createQuery("SELECT d FROM Doctors d").getResultList();

        session.getTransaction().commit();
        session.close();

        return doctorsList;
    }

    @Override
    public Doctors addNewDoctor(Doctors doctor) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.save(doctor);

        session.getTransaction().commit();
        session.close();

        return doctor;
    }

    @Override
    public void deleteDoctorById(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(session.get(Doctors.class, id));

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateDoctor(Integer id, String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        String update = "UPDATE Doctors d SET d.name=:name, d.surname=:surname, d.title=:title, d.licenseNumber=:licenseNumber, d.phone=:phone, d.email=:email, d.nationality=:nationality, d.speciality=:speciality, d.dateOfBirth=:dateOfBirth, d.isATeacher=:isATeacher WHERE d.id=:id";
        Query query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        query.setParameter("title", title);
        query.setParameter("licenseNumber", licenseNumber);
        query.setParameter("phone", phone);
        query.setParameter("email", email);
        query.setParameter("nationality", nationality);
        query.setParameter("speciality", speciality);
        query.setParameter("dateOfBirth", dateOfBirth);
        query.setParameter("isATeacher", isATeacher);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
