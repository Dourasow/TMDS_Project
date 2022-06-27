package com.wisdomtech.tmds.services;

import com.wisdomtech.tmds.models.ViolationCode;
import com.wisdomtech.tmds.repositories.ViolationCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViolationCodeService {

    @Autowired
    private ViolationCodeRepo violationCodeRepo;

    public ViolationCode save(ViolationCode violationCode){
        return violationCodeRepo.save(violationCode);
    }

    public List<ViolationCode> findAll(){
        return violationCodeRepo.findAll();
    }

    public Optional<ViolationCode> findById(Long id){
        return violationCodeRepo.findById(id);
    }

    public void deleteById(Long id){
        violationCodeRepo.deleteById(id);
    }

}
