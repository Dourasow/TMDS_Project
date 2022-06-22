package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.ViolationRecord;
import com.wisdomtech.tmds.services.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/violation-records")
public class ViolationRecordController {

    @Autowired
    private ViolationRecordService violationRecordService;

    @PostMapping(value = "/")
    public ResponseEntity<ViolationRecord> save(@RequestBody ViolationRecord violationRecord){
        ViolationRecord save = violationRecordService.save(violationRecord);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<ViolationRecord> findAll(){
        return violationRecordService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ViolationRecord> findById(@PathVariable("id") Long id){
        return violationRecordService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        violationRecordService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViolationRecord> update(@PathVariable("id") Long id, @RequestBody ViolationRecord violationRecord){
        Optional<ViolationRecord> violationRecordData = violationRecordService.findById(id);
        ViolationRecord _violationRecord = new ViolationRecord();
        if (violationRecordData.isPresent()){
             _violationRecord = violationRecordData.get();
            _violationRecord.setDate(violationRecord.getDate());
            _violationRecord.setStatus(violationRecord.isStatus());
            _violationRecord.setViolation_code(violationRecord.getViolation_code());
            _violationRecord.setPlateNo(violationRecord.getPlateNo());
            return new ResponseEntity<>(violationRecordService.save(_violationRecord), HttpStatus.OK);
        }
        return new ResponseEntity<>(_violationRecord, HttpStatus.OK);
    }

    @GetMapping("/search/{plateNo}")
    public ViolationRecord findByPlateNo(@PathVariable("plateNo") String plateNo){
        return violationRecordService.findByPlateNo(plateNo);
    }
}
