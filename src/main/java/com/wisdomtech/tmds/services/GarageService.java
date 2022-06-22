package com.wisdomtech.tmds.services;

import com.wisdomtech.tmds.models.Garage;
import com.wisdomtech.tmds.repositories.GarageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {

    @Autowired
    private GarageRepo insuranceRecordRepo;

    public Garage save(Garage insuranceRecord){
        return insuranceRecordRepo.save(insuranceRecord);
    }

    public List<Garage> findAll(){
        return insuranceRecordRepo.findAll();
    }

    public Optional<Garage> findById(Long id){
        return insuranceRecordRepo.findById(id);
    }

    public void deleteById(Long id){
        insuranceRecordRepo.deleteById(id);
    }

}
