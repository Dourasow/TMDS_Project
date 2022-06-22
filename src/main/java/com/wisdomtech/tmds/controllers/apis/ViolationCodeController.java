package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.ViolationCode;
import com.wisdomtech.tmds.services.ViolationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/violation-codes")
public class ViolationCodeController {

    @Autowired
    private ViolationCodeService violationCodeService;

    @PostMapping(value = "/")
    public ResponseEntity<ViolationCode> save(@RequestBody ViolationCode violationCode){
        ViolationCode save = violationCodeService.save(violationCode);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<ViolationCode> findAll(){
        return violationCodeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ViolationCode> findById(@PathVariable("id") Long id){
        return violationCodeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        violationCodeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViolationCode> update(@PathVariable("id") Long id, @RequestBody ViolationCode violationCode){
        Optional<ViolationCode> violationCodeData = violationCodeService.findById(id);
        ViolationCode _violationCode = new ViolationCode();
        if (violationCodeData.isPresent()){
             _violationCode = violationCodeData.get();
            _violationCode.setCode(violationCode.getCode());
            _violationCode.setDescription(violationCode.getDescription());
            _violationCode.setChargeAmount(violationCode.getChargeAmount());
            return new ResponseEntity<>(violationCodeService.save(_violationCode), HttpStatus.OK);
        }
        return new ResponseEntity<>(_violationCode, HttpStatus.EXPECTATION_FAILED);
    }
}
