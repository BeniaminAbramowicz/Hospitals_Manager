package com.babramowicz.entities;



import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "hospitals")
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
    private List<HospitalDoctors> hospitalDoctors = new LinkedList<>();

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

    public Hospitals(String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital, List<HospitalDoctors> hospitalDoctors) {
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
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "Idh", nullable = false)
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

    @Column(name = "Country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "Town")
    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "Street")
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "PostalCode")
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "PhoneNumber")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "FaxNumber")
    public String getFaxNumber() {
        return this.faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Column(name = "NumberOfAmbulances")
    public Integer getNumberOfAmbulances() {
        return this.numberOfAmbulances;
    }

    public void setNumberOfAmbulances(Integer numberOfAmbulances) {
        this.numberOfAmbulances = numberOfAmbulances;
    }

    @Column(name = "HelicopterAccess")
    public Boolean getHelicopterAccess() {
        return this.helicopterAccess;
    }

    public void setHelicopterAccess(Boolean helicopterAccess) {
        this.helicopterAccess = helicopterAccess;
    }

    @Column(name = "TeachingHospital")
    public Boolean getTeachingHospital() {
        return this.teachingHospital;
    }

    public void setTeachingHospital(Boolean teachingHospital) {
        this.teachingHospital = teachingHospital;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.hospital", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    public List<HospitalDoctors> getHospitalDoctors() {
        return this.hospitalDoctors;
    }

    public void setHospitalDoctors(List<HospitalDoctors> hospitalDoctors) {
        this.hospitalDoctors = hospitalDoctors;
    }



}