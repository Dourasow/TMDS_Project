package com.wisdomtech.tmds.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ViolationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String description;

    private Double chargeAmount;

    @OneToMany(mappedBy = "violationCode")
    @JsonIgnore
    private List<ViolationRecord> violationRecord;

    public ViolationCode(Long id, String code, String description, Double chargeAmount, List<ViolationRecord> violationRecord) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.chargeAmount = chargeAmount;
        this.violationRecord = violationRecord;
    }

    public ViolationCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public List<ViolationRecord> getViolationRecord() {
        return violationRecord;
    }

    public void setViolationRecord(List<ViolationRecord> violationRecord) {
        this.violationRecord = violationRecord;
    }

    @Override
    public String toString() {
        return "ViolationCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", chargeAmount=" + chargeAmount +
                ", violationRecord=" + violationRecord +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViolationCode that = (ViolationCode) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(description, that.description) && Objects.equals(chargeAmount, that.chargeAmount) && Objects.equals(violationRecord, that.violationRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, description, chargeAmount, violationRecord);
    }
}
