package com.wisdomtech.tmds.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class MechanicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastDateServiced;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectedServiceDate;

    private String plateNo;

    @ManyToOne
    @JoinColumn(
            name = "garage_code",
            insertable = false,
            updatable = false
    )
    private Garage garage;
    private Long garage_code;

    public MechanicalRecord(Long id, Date lastDateServiced, Date expectedServiceDate, String plateNo, Garage garage, Long garage_code) {
        this.id = id;
        this.lastDateServiced = lastDateServiced;
        this.expectedServiceDate = expectedServiceDate;
        this.plateNo = plateNo;
        this.garage = garage;
        this.garage_code = garage_code;
    }

    public MechanicalRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastDateServiced() {
        return lastDateServiced;
    }

    public void setLastDateServiced(Date lastDateServiced) {
        this.lastDateServiced = lastDateServiced;
    }

    public Date getExpectedServiceDate() {
        return expectedServiceDate;
    }

    public void setExpectedServiceDate(Date expectedServiceDate) {
        this.expectedServiceDate = expectedServiceDate;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Long getGarage_code() {
        return garage_code;
    }

    public void setGarage_code(Long garage_code) {
        this.garage_code = garage_code;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public String toString() {
        return "MechanicalRecord{" +
                "id=" + id +
                ", lastDateServiced=" + lastDateServiced +
                ", expectedServiceDate=" + expectedServiceDate +
                ", plateNo='" + plateNo + '\'' +
                ", garage=" + garage +
                ", garage_code=" + garage_code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MechanicalRecord that = (MechanicalRecord) o;
        return Objects.equals(id, that.id) && Objects.equals(lastDateServiced, that.lastDateServiced) && Objects.equals(expectedServiceDate, that.expectedServiceDate) && Objects.equals(plateNo, that.plateNo) && Objects.equals(garage, that.garage) && Objects.equals(garage_code, that.garage_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastDateServiced, expectedServiceDate, plateNo, garage, garage_code);
    }
}
