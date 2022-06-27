package com.wisdomtech.tmds.services;

import com.wisdomtech.tmds.models.ViolationRecord;
import com.wisdomtech.tmds.repositories.ViolationRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViolationRecordService {

    @Autowired
    private ViolationRecordRepo violationRecordRepo;

    public ViolationRecord save(ViolationRecord violationRecord){
        return violationRecordRepo.save(violationRecord);
    }

    public List<ViolationRecord> findAll(){
        return violationRecordRepo.findAll();
    }

    public Optional<ViolationRecord> findById(Long id){
        return violationRecordRepo.findById(id);
    }

    public void deleteById(Long id){
        violationRecordRepo.deleteById(id);
    }

    public List<ViolationRecord> findByPlateNoAndClear(String plateNo, Boolean status){
        return violationRecordRepo.findByPlateNoAndClear(plateNo, status);
    }

}
