package com.wisdomtech.tmds.repositories;

import com.wisdomtech.tmds.models.InsuranceRecord;
import com.wisdomtech.tmds.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Long> {
}
