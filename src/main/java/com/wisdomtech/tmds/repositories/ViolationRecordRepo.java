package com.wisdomtech.tmds.repositories;

import com.wisdomtech.tmds.models.ViolationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRecordRepo extends JpaRepository<ViolationRecord, Long> {

    ViolationRecord findByPlateNo(String plateNo);
}
