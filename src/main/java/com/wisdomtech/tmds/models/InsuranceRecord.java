package com.wisdomtech.tmds.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class InsuranceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateInsured;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateExpired;

    @ManyToOne
    @JoinColumn(
            name = "vendor_id",
            insertable = false,
            updatable = false
    )
    private Vendor vendor;
    private Long vendor_id;

    public InsuranceRecord(Long id, String plateNo, Date dateInsured, Date dateExpired, Vendor vendor, Long vendor_id) {
        this.id = id;
        this.plateNo = plateNo;
        this.dateInsured = dateInsured;
        this.dateExpired = dateExpired;
        this.vendor = vendor;
        this.vendor_id = vendor_id;
    }

    public InsuranceRecord() {
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

    public Date getDateInsured() {
        return dateInsured;
    }

    public void setDateInsured(Date dateInsured) {
        this.dateInsured = dateInsured;
    }

    public Date getDateExpire() {
        return dateExpired;
    }

    public void setDateExpire(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Long vendor_id) {
        this.vendor_id = vendor_id;
    }

    @Override
    public String toString() {
        return "InsuranceRecord{" +
                "id=" + id +
                ", plateNo='" + plateNo + '\'' +
                ", dateInsured=" + dateInsured +
                ", dateExpired=" + dateExpired +
                ", vendor=" + vendor +
                ", vendor_id=" + vendor_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceRecord that = (InsuranceRecord) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNo, that.plateNo) && Objects.equals(dateInsured, that.dateInsured) && Objects.equals(dateExpired, that.dateExpired) && Objects.equals(vendor, that.vendor) && Objects.equals(vendor_id, that.vendor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNo, dateInsured, dateExpired, vendor, vendor_id);
    }
}
