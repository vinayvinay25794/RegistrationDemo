package com.example.Hibernate.Thymeleaf;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Hibernate.Pojo.Candidate;
import com.example.Hibernate.Service.CandidateService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CandidateRegs")
public class UserController {
	@Autowired
    private CandidateService candidateService;
	
	
	@ModelAttribute("user")
	public Candidate candidateDto() {
		return new Candidate();
	}
	
	
	@GetMapping
	public String showRegistrationForm() {
		return "CandidateRegs";
	}
	
	@PostMapping
	public String registerUserAccount(@Valid @ModelAttribute("user") Candidate user,
		   BindingResult result,Model model) {
		if (result.hasErrors()) {
			
	    	model.addAttribute("user", user);
	       
	        return "CandidateRegs";
	    }
		candidateService.save(user);
		return "redirect:/login";
		
	}
	

}
