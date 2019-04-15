package com.babramowicz.dao;

import com.babramowicz.entities.HospitalDoctors;
import org.hibernate.Session;

import javax.ejb.Stateless;
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
}
