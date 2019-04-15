package com.babramowicz.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class HospitalDoctorsId implements Serializable {

    private Hospitals hospital;
    private Doctors doctor;

    @ManyToOne
    public Hospitals getHospital() {
        return hospital;
    }

    public void setHospital(Hospitals hospital) {
        this.hospital = hospital;
    }

    @ManyToOne
    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalDoctorsId that = (HospitalDoctorsId) o;
        if(hospital != null?!hospital.equals(that.hospital) : that.hospital != null) return false;
        if(doctor != null?!doctor.equals(that.doctor) : that.doctor != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (hospital != null? hospital.hashCode() : 0);
        result = 31* result + (doctor != null? doctor.hashCode() : 0);
        return result;
    }
}
