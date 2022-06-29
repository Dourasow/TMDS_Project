package com.wisdomtech.tmds.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class ViolationRecord {

    @Id
    @SequenceGenerator(
            name = "violationRecord_sequence",
            sequenceName = "violationRecord_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "violationRecord_sequence"
    )
    private Long id;

    private String plateNo;
    @Column(name = "clear")
    private Boolean clear;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(
            insertable = false,
            updatable = false,
            name = "violation_code"
    )
    private ViolationCode violationCode;
    private Long violation_code;

    public ViolationRecord() {
    }

    public ViolationRecord(Long id, String plateNo, Boolean clear, Date date, ViolationCode violationCode, Long violation_code) {
        this.id = id;
        this.plateNo = plateNo;
        this.clear = clear;
        this.date = date;
        this.violationCode = violationCode;
        this.violation_code = violation_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Boolean isStatus() {
        return clear;
    }

    public void setStatus(Boolean clear) {
        this.clear = clear;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ViolationCode getViolationCode() {
        return violationCode;
    }

    public void setViolationCode(ViolationCode violationCode) {
        this.violationCode = violationCode;
    }

    public Long getViolation_code() {
        return violation_code;
    }

    public void setViolation_code(Long violation_code) {
        this.violation_code = violation_code;
    }

    @Override
    public String toString() {
        return "ViolationRecord{" +
                "id=" + id +
                ", plateNo='" + plateNo + '\'' +
                ", clear=" + clear +
                ", date=" + date +
                ", violationCode=" + violationCode +
                ", violation_code=" + violation_code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViolationRecord that = (ViolationRecord) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNo, that.plateNo) && Objects.equals(clear, that.clear) && Objects.equals(date, that.date) && Objects.equals(violationCode, that.violationCode) && Objects.equals(violation_code, that.violation_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNo, clear, date, violationCode, violation_code);
    }
}
