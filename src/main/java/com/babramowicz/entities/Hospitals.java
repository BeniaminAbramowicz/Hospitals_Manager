package com.babramowicz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hospitals", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Name"),
        @UniqueConstraint(columnNames = "Country"),
        @UniqueConstraint(columnNames = "Town"),
        @UniqueConstraint(columnNames = "Street"),
        @UniqueConstraint(columnNames = "PostalCode"),
        @UniqueConstraint(columnNames = "PhoneNumber"),
        @UniqueConstraint(columnNames = "FaxNumber"),
        @UniqueConstraint(columnNames = "NumberOfAmbulances"),
        @UniqueConstraint(columnNames = "HelicopterAccess"),
        @UniqueConstraint(columnNames = "TeachingHospital"),
        })
@Data
public class Hospitals implements Serializable {

    private Integer id;
    private String name;
    private String country;
    private String town;
    private String street;
    private String postalCode;
    private String phoneNumber;
    private String faxNumber;
    private Integer numberOfAmbulances;
    private Boolean helicopterAccess;
    private Boolean teachingHospital;
    private Set<HospitalDoctors> hospitalDoctors;

    public Hospitals() {
    }

    public Hospitals(Integer id, String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.town = town;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.numberOfAmbulances = numberOfAmbulances;
        this.helicopterAccess = helicopterAccess;
        this.teachingHospital = teachingHospital;
    }

    public Hospitals(String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital) {
        this.name = name;
        this.country = country;
        this.town = town;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.numberOfAmbulances = numberOfAmbulances;
        this.helicopterAccess = helicopterAccess;
        this.teachingHospital = teachingHospital;
    }

    public Hospitals(String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital, Set<HospitalDoctors> hospitalDoctors) {
        this.name = name;
        this.country = country;
        this.town = town;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.numberOfAmbulances = numberOfAmbulances;
        this.helicopterAccess = helicopterAccess;
        this.teachingHospital = teachingHospital;
        this.hospitalDoctors = hospitalDoctors;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Idh")
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

    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "Town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "Street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "FaxNumber")
    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Column(name = "NumberOfAmbulances")
    public Integer getNumberOfAmbulances() {
        return numberOfAmbulances;
    }

    public void setNumberOfAmbulances(Integer numberOfAmbulances) {
        this.numberOfAmbulances = numberOfAmbulances;
    }

    @Column(name = "HelicopterAccess")
    public Boolean getHelicopterAccess() {
        return helicopterAccess;
    }

    public void setHelicopterAccess(Boolean helicopterAccess) {
        this.helicopterAccess = helicopterAccess;
    }

    @Column(name = "TeachingHospital")
    public Boolean getTeachingHospital() {
        return teachingHospital;
    }

    public void setTeachingHospital(Boolean teachingHospital) {
        this.teachingHospital = teachingHospital;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.hospital", cascade = CascadeType.ALL)
    public Set<HospitalDoctors> getHospitalDoctors() {
        return hospitalDoctors;
    }

    public void setHospitalDoctors(Set<HospitalDoctors> hospitalDoctors) {
        this.hospitalDoctors = hospitalDoctors;
    }



}