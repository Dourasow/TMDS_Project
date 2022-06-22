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
        RedirectView redirectView = new RedirectView("/index", true);

        System.out.println("Plate Number: " + plateNo);

        ViolationRecord violationRecord = violationRecordService.findByPlateNo(plateNo);
        MechanicalRecord mechanicalRecord = mechanicalRecordService.findByPlateNo(plateNo);
        InsuranceRecord insuranceRecord = insuranceRecordService.findByPlateNo(plateNo);

//        System.out.println("Violation Record: " + violationRecord.getPlateNo());
//        System.out.println("Mechanical Record: " + mechanicalRecord.getPlateNo());
//        System.out.println("Insurance Record: " + insuranceRecord.getPlateNo());

        redirectAttributes.addFlashAttribute("violationRecord", violationRecord);
        redirectAttributes.addFlashAttribute("mechanicalRecord", mechanicalRecord);
        redirectAttributes.addFlashAttribute("insuranceRecord", insuranceRecord);

        if (violationRecord == null && mechanicalRecord == null && insuranceRecord == null){
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