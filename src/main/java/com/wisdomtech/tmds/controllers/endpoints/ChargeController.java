package com.wisdomtech.tmds.controllers.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.wisdomtech.tmds.services.ViolationCodeService;
import com.wisdomtech.tmds.services.ViolationRecordService;

@Controller
public class ChargeController {

	@Autowired
	private ViolationCodeService violationCodeService;
	
	@GetMapping("/charges")
    public String showAddPage(Model model) {
		model.addAttribute("violationCodes", violationCodeService.findAll());
    	return "charge";
    }
	
//	@GetMapping("/charges")
//    public RedirectView chargePage(Model model, RedirectAttributes redirectAttributes) {
//		RedirectView redirectView = new RedirectView("/home", true);
//		
//		
//    	return "charge";
//    }
}
