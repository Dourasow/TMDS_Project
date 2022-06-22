package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.Vendor;
import com.wisdomtech.tmds.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(value = "/")
    public ResponseEntity<Vendor> save(@RequestBody Vendor vendor){
        Vendor save = vendorService.save(vendor);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Vendor> findAll(){
        return vendorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vendor> findById(@PathVariable("id") Long id){
        return vendorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        vendorService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> update(@PathVariable("id") Long id, @RequestBody Vendor vendor){
        Optional<Vendor> vendorData = vendorService.findById(id);
        Vendor _vendor = new Vendor();
        if (vendorData.isPresent()){
            _vendor = vendorData.get();
            _vendor.setDescription(vendor.getDescription());
            _vendor.setBrand(vendor.getBrand());
            return new ResponseEntity<>(vendorService.save(_vendor), HttpStatus.OK);
        }
        return new ResponseEntity<>(_vendor, HttpStatus.OK);
    }
}
