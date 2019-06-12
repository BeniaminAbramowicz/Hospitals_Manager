package com.babramowicz.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_doctor")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Title")
    private String title;
    @Column(name = "License_number")
    private String licenseNumber;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Nationality")
    private String nationality;
    @Column(name = "Speciality")
    private String speciality;
    @Column(name = "Date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "Is_a_teacher")
    private Boolean isATeacher;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<HospitalDoctors> hospitalDoctors;


    public Doctor() {
    }

    public Doctor(Integer id, String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.email = email;
        this.nationality = nationality;
        this.speciality = speciality;
        this.dateOfBirth = dateOfBirth;
        this.isATeacher = isATeacher;
    }

    public Doctor(String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.email = email;
        this.nationality = nationality;
        this.speciality = speciality;
        this.dateOfBirth = dateOfBirth;
        this.isATeacher = isATeacher;
    }

    public Doctor(String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher, List<HospitalDoctors> hospitalDoctors) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.email = email;
        this.nationality = nationality;
        this.speciality = speciality;
        this.dateOfBirth = dateOfBirth;
        this.isATeacher = isATeacher;
        this.hospitalDoctors = hospitalDoctors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getisATeacher() {
        return isATeacher;
    }

    public void setisATeacher(Boolean isATeacher) {
        this.isATeacher = isATeacher;
    }

    public List<HospitalDoctors> getHospitalDoctors() {
        return hospitalDoctors;
    }

    public void setHospitalDoctors(List<HospitalDoctors> hospitalDoctors) {
        this.hospitalDoctors = hospitalDoctors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id) &&
                name.equals(doctor.name) &&
                surname.equals(doctor.surname) &&
                title.equals(doctor.title) &&
                licenseNumber.equals(doctor.licenseNumber) &&
                phone.equals(doctor.phone) &&
                email.equals(doctor.email) &&
                nationality.equals(doctor.nationality) &&
                speciality.equals(doctor.speciality) &&
                dateOfBirth.equals(doctor.dateOfBirth) &&
                isATeacher.equals(doctor.isATeacher) &&
                hospitalDoctors.equals(doctor.hospitalDoctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, title, licenseNumber, phone, email, nationality, speciality, dateOfBirth, isATeacher, hospitalDoctors);
    }

    @Override
    public String toString() {
        return licenseNumber;
    }
}