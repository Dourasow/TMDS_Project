package com.wisdomtech.tmds.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Vendor {

    @Id
    @SequenceGenerator(
            name = "vendor_sequence",
            sequenceName = "vendor_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vendor_sequence"
    )
    private Long id;
    private String brand;
    private String description;

    @OneToMany(mappedBy = "vendor")
    @JsonIgnore
    private List<InsuranceRecord> insuranceRecordList;

    public Vendor(Long id, String brand, String description, List<InsuranceRecord> insuranceRecordList) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.insuranceRecordList = insuranceRecordList;
    }

    public Vendor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InsuranceRecord> getInsuranceRecordList() {
        return insuranceRecordList;
    }

    public void setInsuranceRecordList(List<InsuranceRecord> insuranceRecordList) {
        this.insuranceRecordList = insuranceRecordList;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", insuranceRecordList=" + insuranceRecordList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equals(id, vendor.id) && Objects.equals(brand, vendor.brand) && Objects.equals(description, vendor.description) && Objects.equals(insuranceRecordList, vendor.insuranceRecordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, description, insuranceRecordList);
    }
}
