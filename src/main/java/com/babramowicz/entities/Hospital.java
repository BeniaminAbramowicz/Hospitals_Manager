package com.babramowicz.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hospital")
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_hospital")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Country")
    private String country;
    @Column(name = "Town")
    private String town;
    @Column(name = "Street")
    private String street;
    @Column(name = "Postal_code")
    private String postalCode;
    @Column(name = "Phone_number")
    private String phoneNumber;
    @Column(name = "Fax_number")
    private String faxNumber;
    @Column(name = "Number_of_ambulances")
    private Integer numberOfAmbulances;
    @Column(name = "Helicopter_access")
    private Boolean helicopterAccess;
    @Column(name = "Teaching_hospital")
    private Boolean teachingHospital;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.EAGER)
    private List<HospitalDoctors> hospitalDoctors;

    public Hospital() {
    }

    public Hospital(Integer id, String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital) {
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

    public Hospital(String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital) {
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

    public Hospital(String name, String country, String town, String street, String postalCode, String phoneNumber, String faxNumber, Integer numberOfAmbulances, Boolean helicopterAccess, Boolean teachingHospital, List<HospitalDoctors> hospitalDoctors) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Integer getNumberOfAmbulances() {
        return numberOfAmbulances;
    }

    public void setNumberOfAmbulances(Integer numberOfAmbulances) {
        this.numberOfAmbulances = numberOfAmbulances;
    }

    public Boolean getHelicopterAccess() {
        return helicopterAccess;
    }

    public void setHelicopterAccess(Boolean helicopterAccess) {
        this.helicopterAccess = helicopterAccess;
    }

    public Boolean getTeachingHospital() {
        return teachingHospital;
    }

    public void setTeachingHospital(Boolean teachingHospital) {
        this.teachingHospital = teachingHospital;
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
        Hospital hospital = (Hospital) o;
        return id.equals(hospital.id) &&
                name.equals(hospital.name) &&
                country.equals(hospital.country) &&
                town.equals(hospital.town) &&
                street.equals(hospital.street) &&
                postalCode.equals(hospital.postalCode) &&
                phoneNumber.equals(hospital.phoneNumber) &&
                faxNumber.equals(hospital.faxNumber) &&
                numberOfAmbulances.equals(hospital.numberOfAmbulances) &&
                helicopterAccess.equals(hospital.helicopterAccess) &&
                teachingHospital.equals(hospital.teachingHospital) &&
                hospitalDoctors.equals(hospital.hospitalDoctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, town, street, postalCode, phoneNumber, faxNumber, numberOfAmbulances, helicopterAccess, teachingHospital, hospitalDoctors);
    }

    @Override
    public String toString() {
        return name;
    }
}