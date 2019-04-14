package com.babramowicz.dao;

import com.babramowicz.entities.Hospitals;

import java.util.List;

public interface HospitalsRepositoryDao {

    Hospitals getHospitalById(int id);
    Hospitals getHospitalByName(String name);
    List<Hospitals> getHospitalsList();
    Hospitals addNewHospital(Hospitals hospital);
    void deleteHospitalById(int id);
    void updateHospital(Integer id, String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital);

}
