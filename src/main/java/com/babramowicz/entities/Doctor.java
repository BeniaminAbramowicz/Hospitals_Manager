package com.babramowicz.entities;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "doctors")
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
    private List<HospitalDoctors> hospitalDoctors = new LinkedList<>();


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

    public Doctors(String name, String surname, String title, String licenseNumber, String phone, String email, String nationality, String speciality, LocalDate dateOfBirth, Boolean isATeacher, List<HospitalDoctors> hospitalDoctors) {
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
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "Idd", nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Surname")
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "Title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "LicenseNumber")
    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Column(name = "Phone")
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "Email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Nationality")
    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "Speciality")
    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Column(name = "DateofBirth")
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "IsaTeacher")
    public Boolean getIsATeacher() {
        return this.isATeacher;
    }

    public void setIsATeacher(Boolean isATeacher) {
        this.isATeacher = isATeacher;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.doctor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    public List<HospitalDoctors> getHospitalDoctors() {
        return hospitalDoctors;
    }

    public void setHospitalDoctors(List<HospitalDoctors> hospitalDoctors) {
        this.hospitalDoctors = hospitalDoctors;
    }



}