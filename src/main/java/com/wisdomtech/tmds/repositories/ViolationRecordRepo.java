package com.wisdomtech.tmds.repositories;

import com.wisdomtech.tmds.models.ViolationRecord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRecordRepo extends JpaRepository<ViolationRecord, Long> {

    List<ViolationRecord> findByPlateNoAndClear(String plateNo, Boolean status);
    
}
