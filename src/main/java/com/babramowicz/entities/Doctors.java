package com.babramowicz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Data
public class Doctors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Title")
    private String title;
    @Column(name = "License Number")
    private String licenseNumber;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Nationality")
    private String nationality;
    @Column(name = "Speciality")
    private String speciality;
    @Column(name = "Date of Birth")
    private LocalDate dateOfBirth;
    @Column(name = "Is a Teacher")
    private Boolean isATeacher;

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
}