package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.Garage;
import com.wisdomtech.tmds.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/garages")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @PostMapping(value = "/")
    public ResponseEntity<Garage> save(@RequestBody Garage garage){
        Garage save = garageService.save(garage);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Garage> findAll(){
        return garageService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Garage> findById(@PathVariable("id") Long id){
        return garageService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        garageService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garage> update(@PathVariable("id") Long id, @RequestBody Garage garage){
        Optional<Garage> garageData = garageService.findById(id);
        Garage _garage = new Garage();
        if (garageData.isPresent()){
            _garage = garageData.get();
            _garage.setDescription(garage.getDescription());
            _garage.setAddress(garage.getAddress());
            _garage.setPhone(garage.getPhone());
            _garage.setManagerName(garage.getManagerName());

            return new ResponseEntity<>(garageService.save(_garage), HttpStatus.OK);
        }
        return new ResponseEntity<>(_garage, HttpStatus.EXPECTATION_FAILED);
    }
}
