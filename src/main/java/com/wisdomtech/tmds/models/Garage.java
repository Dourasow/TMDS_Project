package com.wisdomtech.tmds.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Garage {
    @Id
    @SequenceGenerator(
            name = "garage_sequence",
            sequenceName = "garage_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "garage_sequence"
    )
    private Long garage_code;

    private String description;
    private String address;
    private String managerName;
    private String phone;

    @OneToMany(mappedBy = "garage")
    private List<MechanicalRecord> mechanicalRecord;

    public Garage(Long garage_code, String description, String address, String managerName, String phone, List<MechanicalRecord> mechanicalRecord) {
        this.garage_code = garage_code;
        this.description = description;
        this.address = address;
        this.managerName = managerName;
        this.phone = phone;
        this.mechanicalRecord = mechanicalRecord;
    }

    public Garage() {
    }

    public Long getGarage_code() {
        return garage_code;
    }

    public void setGarage_code(Long garage_code) {
        this.garage_code = garage_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "garage_code=" + garage_code +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", managerName='" + managerName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(garage_code, garage.garage_code) && Objects.equals(description, garage.description) && Objects.equals(address, garage.address) && Objects.equals(managerName, garage.managerName) && Objects.equals(phone, garage.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garage_code, description, address, managerName, phone);
    }
}
