package com.wisdomtech.tmds.services;

import com.wisdomtech.tmds.models.MechanicalRecord;
import com.wisdomtech.tmds.repositories.MechanicalRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicalRecordService {

    @Autowired
    private MechanicalRecordRepo mechanicalRecordRepo;

    public MechanicalRecord save(MechanicalRecord insuranceRecord){
        return mechanicalRecordRepo.save(insuranceRecord);
    }

    public List<MechanicalRecord> findAll(){
        return mechanicalRecordRepo.findAll();
    }

    public Optional<MechanicalRecord> findById(Long id){
        return mechanicalRecordRepo.findById(id);
    }

    public void deleteById(Long id){
        mechanicalRecordRepo.deleteById(id);
    }

    public MechanicalRecord findByPlateNo(String plateNo){
        return mechanicalRecordRepo.findByPlateNo(plateNo);
    }
}
