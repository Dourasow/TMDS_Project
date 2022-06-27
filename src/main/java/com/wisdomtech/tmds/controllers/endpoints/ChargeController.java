package com.wisdomtech.tmds.controllers.endpoints;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.wisdomtech.tmds.models.ViolationRecord;
import com.wisdomtech.tmds.services.ViolationCodeService;
import com.wisdomtech.tmds.services.ViolationRecordService;

@Controller
public class ChargeController {

	@Autowired
	private ViolationCodeService violationCodeService;
	
	@Autowired
	private ViolationRecordService violationRecordService;
	
	@GetMapping("/charges")
    public String showAddPage(Model model) {
		model.addAttribute("violationCodes", violationCodeService.findAll());
    	return "charge";
    }
	
	@GetMapping("/charges/{plateNo}")
    public RedirectView showAddPage(RedirectAttributes redirectAttributes, @PathVariable("plateNo") String plateNo) {
		RedirectView redirectView = new RedirectView("/charges", true);
		
		redirectAttributes.addFlashAttribute("plateNo", plateNo);
		
    	return redirectView;
    }
	
	@PostMapping("/charges/add")
    public RedirectView chargePage(Model model, RedirectAttributes redirectAttributes, @RequestParam("plateNo") String plateNo, @RequestParam("v_code") List<Long> violationCodes) {
		RedirectView redirectView = new RedirectView("/home", true);
		
		if (plateNo != null && violationCodes != null) {
			System.out.println("I got here!");
			System.out.println(violationCodes);
			System.out.println(plateNo);
			
			for (Long violationCode : violationCodes) {
				ViolationRecord violationRecord = new ViolationRecord();
				violationRecord.setPlateNo(plateNo);
				violationRecord.setDate(new Date());
				violationRecord.setStatus(false);
				violationRecord.setViolation_code(violationCode);
				violationRecordService.save(violationRecord);
			}
			
		}
		
		//violationRecordService.save(violationRecord);
		redirectAttributes.addFlashAttribute("receipt", "Successfully Billed");
		
    	return redirectView;
    }
}
