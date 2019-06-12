package com.babramowicz.dao;


import com.babramowicz.entities.HospitalDoctors;


import java.util.List;

public interface HireRepositoryDao {

    List<HospitalDoctors> getHiredList();
    HospitalDoctors hireDoctor(HospitalDoctors hospitalDoctor);
    HospitalDoctors getHiredByIds(Integer idHospital, Integer idDoctor);
}
