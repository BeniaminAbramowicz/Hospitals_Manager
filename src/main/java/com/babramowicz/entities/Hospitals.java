package com.babramowicz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hospitals")
@Data
public class Hospitals implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Country")
    private String country;
    @Column(name = "Town")
    private String town;
    @Column(name = "Street")
    private String street;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "FaxNumber")
    private String faxNumber;
    @Column(name = "NumberOfAmbulances")
    private String numberOfAmbulances;
    @Column(name = "HelicopterAccess")
    private Boolean helicopterAccess;
    @Column(name = "TeachingHospital")
    private Boolean teachingHospital;


}