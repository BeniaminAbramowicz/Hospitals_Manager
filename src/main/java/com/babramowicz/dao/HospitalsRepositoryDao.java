package com.babramowicz.dao;

import com.babramowicz.entities.Hospitals;

import java.util.List;

public interface HospitalsRepositoryDao {

    List<Hospitals> getHospitalsList();
    Hospitals addNewHospital(Hospitals hospital);
}
