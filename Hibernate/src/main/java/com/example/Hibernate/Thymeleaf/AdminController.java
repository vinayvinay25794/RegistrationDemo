package com.example.Hibernate.Thymeleaf;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Hibernate.Service.CandidateService;
import com.example.Hibernate.Service.UserService;
import com.example.Hibernate.Thymeleaf.dto.UserDto;


@Controller
@RequestMapping("/registration")
public class AdminController {

	@Autowired
    private CandidateService candidateService;
	
	@Autowired
    private UserService userService;
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@Valid @ModelAttribute("user") UserDto user, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
	    	        
	    	model.addAttribute("user", user);
	       
	        return "registration";
	    }
		userService.save(user);
		 model.addAttribute("allEmps", candidateService.findAll());
		return "allRegistrations";
		
	}
	

	
}
