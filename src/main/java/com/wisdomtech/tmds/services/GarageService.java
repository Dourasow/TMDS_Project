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
    private GarageRepo garageRepo;

    //Get All
    public List<Garage> findAll()
    {
        return garageRepo.findAll();
    }

    public void save(Garage garage)
    {
        garageRepo.save(garage);
    }

    public void delete(Integer id)
    {
        garageRepo.delete(garageRepo.getById(id));
    }

    public Garage findById(Integer id) {
        return garageRepo.findById(id).orElse(null);
    }

}

  /*  public Garage save(Garage garage){
        return garageRepo.save(garage);
    }

    public List<Garage> findAll(){
        return garageRepo.findAll();
    }

    public Optional<Garage> findById(int id){
        return garageRepo.findById((long) id);
    }

    public Garage findById(Integer id) {
        return garageRepo.findById(id.longValue()).orElse(null);
    }

    public void deleteById(Long id){
        garageRepo.deleteById(id);
    }

}*/
