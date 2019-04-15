package com.babramowicz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "hospitaldoctors")
@AssociationOverrides({
        @AssociationOverride(name = "pk.hospital",
                joinColumns = @JoinColumn(name = "Idh")),
        @AssociationOverride(name = "pk.doctor",
                joinColumns = @JoinColumn(name = "Idd"))
})
@Data
public class HospitalDoctors implements Serializable {

    private Integer id;
    private Integer idH;
    private Integer idD;
    private HospitalDoctorsId pk = new HospitalDoctorsId();
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String position;
    private Boolean supervisor;
    private Boolean partTime;

    public HospitalDoctors(){

    }

    public HospitalDoctors(Integer id, Integer idH, Integer idD, LocalDate contractStartDate, LocalDate contractEndDate, String position, Boolean supervisor, Boolean partTime) {
        this.id = id;
        this.idH = idH;
        this.idD = idD;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.position = position;
        this.supervisor = supervisor;
        this.partTime = partTime;
    }

    public HospitalDoctors(Integer idH, Integer idD, LocalDate contractStartDate, LocalDate contractEndDate, String position, Boolean supervisor, Boolean partTime) {
        this.idH = idH;
        this.idD = idD;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.position = position;
        this.supervisor = supervisor;
        this.partTime = partTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "Idh")
    public Integer getIdh() {
        return idH;
    }

    public void setIdh(Integer idH) {
        this.idH = idH;
    }
    @Column(name = "Idd")
    public Integer getIdd() {
        return idD;
    }

    public void setIdd(Integer idD) {
        this.idD = idD;
    }

    @EmbeddedId
    public HospitalDoctorsId getPk() {
        return pk;
    }

    public void setPk(HospitalDoctorsId pk) {
        this.pk = pk;
    }

    @Transient
    public Hospitals getHospital(){
        return getPk().getHospital();
    }

    public void setHospital(Hospitals hospital){
        getPk().setHospital(hospital);
    }

    @Transient
    public Doctors getDoctor(){
        return getPk().getDoctor();
    }

    public void setDoctor(Doctors doctor){
        getPk().setDoctor(doctor);
    }

    @Column(name = "ContractStartDate")
    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    @Column(name = "ContractEndDate")
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    @Column(name = "Position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "Supervisor")
    public Boolean getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Boolean supervisor) {
        this.supervisor = supervisor;
    }

    @Column(name = "PartTime")
    public Boolean getPartTime() {
        return partTime;
    }

    public void setPartTime(Boolean partTime) {
        this.partTime = partTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalDoctors that = (HospitalDoctors) o;
        if(getPk() != null?!getPk().equals(that.getPk()) : that.getPk() != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null? getPk().hashCode() : 0);
    }
}
