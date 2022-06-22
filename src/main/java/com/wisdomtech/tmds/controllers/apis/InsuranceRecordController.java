package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.InsuranceRecord;
import com.wisdomtech.tmds.services.InsuranceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insurance-records")
public class InsuranceRecordController {

    @Autowired
    private InsuranceRecordService insuranceRecordService;

    @PostMapping(value = "/")
    public ResponseEntity<InsuranceRecord> save(@RequestBody InsuranceRecord insuranceRecord){
        InsuranceRecord save = insuranceRecordService.save(insuranceRecord);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<InsuranceRecord> findAll(){
        return insuranceRecordService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<InsuranceRecord> findById(@PathVariable("id") Long id){
        return insuranceRecordService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        insuranceRecordService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceRecord> update(@PathVariable("id") Long id, @RequestBody InsuranceRecord insuranceRecord){
        Optional<InsuranceRecord> insuranceRecordData = insuranceRecordService.findById(id);
        InsuranceRecord _insuranceRecord = new InsuranceRecord();
        if (insuranceRecordData.isPresent()){
            _insuranceRecord = insuranceRecordData.get();
            _insuranceRecord.setDateInsured(insuranceRecord.getDateInsured());
            _insuranceRecord.setDateExpire(insuranceRecord.getDateExpire());
            _insuranceRecord.setPlateNo(insuranceRecord.getPlateNo());
            _insuranceRecord.setVendor_id(insuranceRecord.getVendor_id());
            return new ResponseEntity<>(insuranceRecordService.save(_insuranceRecord), HttpStatus.OK);
        }
        return new ResponseEntity<>(_insuranceRecord, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/search/{plateNo}")
    public InsuranceRecord findByPlateNo(@PathVariable("plateNo") String plateNo){
        return insuranceRecordService.findByPlateNo(plateNo);
    }
}
