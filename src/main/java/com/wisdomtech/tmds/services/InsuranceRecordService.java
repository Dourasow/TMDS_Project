package com.wisdomtech.tmds.services;

import com.wisdomtech.tmds.models.InsuranceRecord;
import com.wisdomtech.tmds.repositories.InsuranceRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceRecordService {

    @Autowired
    private InsuranceRecordRepo insuranceRecordRepo;

    public InsuranceRecord save(InsuranceRecord insuranceRecord){
        return insuranceRecordRepo.save(insuranceRecord);
    }

    public List<InsuranceRecord> findAll(){
        return insuranceRecordRepo.findAll();
    }

    public Optional<InsuranceRecord> findById(Long id){
        return insuranceRecordRepo.findById(id);
    }

    public void deleteById(Long id){
        insuranceRecordRepo.deleteById(id);
    }

    public InsuranceRecord findByPlateNo(String plateNo){
        return insuranceRecordRepo.findByPlateNo(plateNo);
    }

}
