package com.wisdomtech.tmds.repositories;

import com.wisdomtech.tmds.models.InsuranceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRecordRepo extends JpaRepository<InsuranceRecord, Long> {

    InsuranceRecord findByPlateNo(String plateNo);
}