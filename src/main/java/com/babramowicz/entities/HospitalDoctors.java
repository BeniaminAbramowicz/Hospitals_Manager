package com.babramowicz.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "hospitaldoctor")
public class HospitalDoctors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_hospital")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "Id_doctor")
    private Doctor doctor;

    @Column(name = "Contract_start_date")
    private LocalDate contractStartDate;
    @Column(name = "Contract_end_date")
    private LocalDate contractEndDate;
    @Column(name = "Position")
    private String position;
    @Column(name = "Supervisor")
    private Boolean supervisor;
    @Column(name = "Part_time")
    private Boolean partTime;

    public HospitalDoctors(){

    }

    public HospitalDoctors(Hospital hospital, Doctor doctor, LocalDate contractStartDate, LocalDate contractEndDate, String position, Boolean supervisor, Boolean partTime){
        this.hospital = hospital;
        this.doctor = doctor;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.position = position;
        this.supervisor = supervisor;
        this.partTime = partTime;
    }

    public HospitalDoctors(LocalDate contractStartDate, LocalDate contractEndDate, String position, Boolean supervisor, Boolean partTime){
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.position = position;
        this.supervisor = supervisor;
        this.partTime = partTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Boolean supervisor) {
        this.supervisor = supervisor;
    }

    public Boolean getPartTime() {
        return partTime;
    }

    public void setPartTime(Boolean partTime) {
        this.partTime = partTime;
    }

    @Override
    public String toString() {
        return "HospitalDoctors{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", doctor=" + doctor+
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", position='" + position + '\'' +
                ", supervisor=" + supervisor +
                ", partTime=" + partTime +
                '}';
    }
}
