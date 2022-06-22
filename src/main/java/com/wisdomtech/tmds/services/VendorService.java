package com.wisdomtech.tmds.services;

import com.wisdomtech.tmds.models.Vendor;
import com.wisdomtech.tmds.repositories.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    public Vendor save(Vendor vendor){
        return vendorRepo.save(vendor);
    }

    public List<Vendor> findAll(){
        return vendorRepo.findAll();
    }

    public Optional<Vendor> findById(Long id){
        return vendorRepo.findById(id);
    }

    public void deleteById(Long id){
        vendorRepo.deleteById(id);
    }

}
