package com.babramowicz.dao;

import com.babramowicz.entities.Doctor;

import java.time.LocalDate;
import java.util.List;

public interface DoctorsRepositoryDao {

    Doctor getDoctorById(int id);
    Doctor getDoctorByLicenseNumber(String licenseNumber);
    List<Doctor> getDoctorsList();
    Doctor addNewDoctor(Doctor doctor);
    void deleteDoctorById(int id);
    void updateDoctor(Integer id, String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher);
}
