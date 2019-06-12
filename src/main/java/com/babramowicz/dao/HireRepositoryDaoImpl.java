package com.babramowicz.dao;

import com.babramowicz.entities.Doctor;
import com.babramowicz.entities.HospitalDoctors;
import com.babramowicz.entities.Hospital;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

import static com.babramowicz.utils.HibernateUtil.getSessionFactory;

@Stateless
public class HireRepositoryDaoImpl implements HireRepositoryDao {

    @Override
    public List<HospitalDoctors> getHiredList() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        List<HospitalDoctors> hiredList = session.createQuery("SELECT k FROM HospitalDoctors k").getResultList();

        session.getTransaction().commit();
        session.close();

        return hiredList;
    }

    @Override
    public HospitalDoctors hireDoctor(HospitalDoctors hospitalDoctor) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.save(hospitalDoctor);

        session.getTransaction().commit();
        session.close();

        return hospitalDoctor;
    }

    @Override
    public HospitalDoctors getHiredByIds(Integer idHospital, Integer idDoctor) {
        HospitalDoctors hospitalDoctors;
        try {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            String select = "SELECT k from HospitalDoctors k WHERE hospital.id=:hospital AND doctor.id=:doctor";
            Query query = session.createQuery(select);
            query.setParameter("hospital", idHospital);
            query.setParameter("doctor", idDoctor);
            hospitalDoctors = (HospitalDoctors) query.getSingleResult();
            session.getTransaction().commit();
            session.close();
            return hospitalDoctors;
        } catch (NoResultException e) {
        }
        return null;
    }
}
