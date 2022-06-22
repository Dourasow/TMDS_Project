package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.MechanicalRecord;
import com.wisdomtech.tmds.services.MechanicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mechanical-records")
public class MechanicalRecordController {

    @Autowired
    private MechanicalRecordService mechanicalRecordService;

    @PostMapping(value = "/")
    public ResponseEntity<MechanicalRecord> save(@RequestBody MechanicalRecord mechanicalRecord){
        MechanicalRecord save = mechanicalRecordService.save(mechanicalRecord);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<MechanicalRecord> findAll(){
        return mechanicalRecordService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MechanicalRecord> findById(@PathVariable("id") Long id){
        return mechanicalRecordService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        mechanicalRecordService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MechanicalRecord> update(@PathVariable("id") Long id, @RequestBody MechanicalRecord mechanicalRecord){
        Optional<MechanicalRecord> mechanicalRecordData = mechanicalRecordService.findById(id);
        MechanicalRecord _mechanicalRecord = new MechanicalRecord();
        if (mechanicalRecordData.isPresent()){
            _mechanicalRecord = mechanicalRecordData.get();
            _mechanicalRecord.setExpectedServiceDate(mechanicalRecord.getExpectedServiceDate());
            _mechanicalRecord.setGarage_code(mechanicalRecord.getGarage_code());
            _mechanicalRecord.setLastDateServiced(mechanicalRecord.getLastDateServiced());
            _mechanicalRecord.setPlateNo(mechanicalRecord.getPlateNo());

            return new ResponseEntity<>(mechanicalRecordService.save(_mechanicalRecord), HttpStatus.OK);
        }
        return new ResponseEntity<>(_mechanicalRecord, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/search/{plateNo}")
    public MechanicalRecord findByPlateNo(@PathVariable("plateNo") String plateNo){
        return mechanicalRecordService.findByPlateNo(plateNo);
    }
}
