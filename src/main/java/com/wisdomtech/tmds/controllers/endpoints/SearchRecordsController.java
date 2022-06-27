package com.wisdomtech.tmds.controllers.endpoints;

import com.wisdomtech.tmds.models.InsuranceRecord;
import com.wisdomtech.tmds.models.MechanicalRecord;
import com.wisdomtech.tmds.models.ViolationRecord;
import com.wisdomtech.tmds.services.InsuranceRecordService;
import com.wisdomtech.tmds.services.MechanicalRecordService;
import com.wisdomtech.tmds.services.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@Controller
public class SearchRecordsController {

    @Autowired
    private ViolationRecordService violationRecordService;

    @Autowired
    private MechanicalRecordService mechanicalRecordService;

    @Autowired
    private InsuranceRecordService insuranceRecordService;

    @GetMapping("/searchRecord")
    public RedirectView search(@RequestParam("plateNo") String plateNo, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/home", true);

        System.out.println("Plate Number: " + plateNo);

        List<ViolationRecord> violationRecordList = violationRecordService.findByPlateNoAndClear(plateNo, false);
        MechanicalRecord mechanicalRecord = mechanicalRecordService.findByPlateNo(plateNo);
        InsuranceRecord insuranceRecord = insuranceRecordService.findByPlateNo(plateNo);

//        System.out.println("Violation Record: " + violationRecord.getPlateNo());
//        System.out.println("Mechanical Record: " + mechanicalRecord.getPlateNo());
//        System.out.println("Insurance Record: " + insuranceRecord.getPlateNo());

        redirectAttributes.addFlashAttribute("violationRecordList", violationRecordList);
        redirectAttributes.addFlashAttribute("mechanicalRecord", mechanicalRecord);
        redirectAttributes.addFlashAttribute("insuranceRecord", insuranceRecord);
        
        if(!violationRecordList.isEmpty()) {
        	String violationStatus = "clear";
        	Double totalCharges = 0.00;
        	
        	System.out.println("I am here");
        	for (ViolationRecord _violationRecord : violationRecordList) {
        		totalCharges += _violationRecord.getViolationCode().getChargeAmount();
        		
    			if(_violationRecord.isStatus() == false) {
    				violationStatus = "not clear";
    				System.out.println("I am here 2");
    			}
    		}
        	
        	redirectAttributes.addFlashAttribute("totalCharges", totalCharges);
			redirectAttributes.addFlashAttribute("violationStatus", violationStatus);
			redirectAttributes.addFlashAttribute("plateNo", plateNo);
        }

        if (violationRecordList.isEmpty() && mechanicalRecord == null && insuranceRecord == null){
            redirectAttributes.addFlashAttribute("foundStatus", false);
            redirectAttributes.addFlashAttribute("responseMessage", "Plate Does Not Exits!");
        }else{
            redirectAttributes.addFlashAttribute("foundStatus", true);
        }

        if(mechanicalRecord != null){
            if (mechanicalRecord.getExpectedServiceDate().after(mechanicalRecord.getLastDateServiced())){
                redirectAttributes.addFlashAttribute("mechanicalCheckStatus", true);
            }else {
                redirectAttributes.addFlashAttribute("mechanicalCheckStatus", false);
            }
        }

        if (insuranceRecord != null){
            if (insuranceRecord.getDateExpire().after(new Date())){
                redirectAttributes.addFlashAttribute("insuranceStatus", true);
            }else {
                redirectAttributes.addFlashAttribute("insuranceStatus", false);
            }
        }

        return redirectView;
    }

}