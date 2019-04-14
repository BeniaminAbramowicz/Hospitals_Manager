package com.babramowicz.dao;

import com.babramowicz.entities.Doctors;

import java.time.LocalDate;
import java.util.List;

public interface DoctorsRepositoryDao {

    Doctors getDoctorById(int id);
    Doctors getDoctorByLicenseNumber(String licenseNumber);
    List<Doctors> getDoctorsList();
    Doctors addNewDoctor(Doctors doctor);
    void deleteDoctorById(int id);
    void updateDoctor(Integer id, String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher);
}
