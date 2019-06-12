package com.babramowicz.dao;

import com.babramowicz.entities.Hospital;

import java.util.List;

public interface HospitalsRepositoryDao {

    Hospital getHospitalById(int id);
    Hospital getHospitalByName(String name);
    List<Hospital> getHospitalsList();
    Hospital addNewHospital(Hospital hospital);
    void deleteHospitalById(int id);
    void updateHospital(Integer id, String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital);

}
