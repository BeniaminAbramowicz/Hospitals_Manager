package com.babramowicz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "doctors")
@Data
public class Doctors implements Serializable {


    private Integer id;

    private String name;

    private String surname;

    private String title;

    private String licenseNumber;

    private String phone;

    private String email;

    private String nationality;

    private String speciality;

    private LocalDate dateOfBirth;

    private Boolean isATeacher;

    private Set<HospitalDoctors> hospitalDoctors;


    public Doctors() {
    }

    public Doctors(Integer id, String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher) {
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

    public Doctors(String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher) {
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

    public Doctors(String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher, Set<HospitalDoctors> hospitalDoctors) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Idd")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "LicenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "Speciality")
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Column(name = "DateofBirth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "IsaTeacher")
    public Boolean getATeacher() {
        return isATeacher;
    }

    public void setATeacher(Boolean ATeacher) {
        isATeacher = ATeacher;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.doctor", cascade = CascadeType.ALL)
    public Set<HospitalDoctors> getHospitalDoctors() {
        return hospitalDoctors;
    }

    public void setHospitalDoctors(Set<HospitalDoctors> hospitalDoctors) {
        this.hospitalDoctors = hospitalDoctors;
    }



}