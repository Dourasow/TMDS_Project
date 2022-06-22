package com.wisdomtech.tmds.repositories;

import com.wisdomtech.tmds.models.Garage;
import com.wisdomtech.tmds.models.MechanicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicalRecordRepo extends JpaRepository<MechanicalRecord, Long> {

    MechanicalRecord findByPlateNo(String plateNo);
}