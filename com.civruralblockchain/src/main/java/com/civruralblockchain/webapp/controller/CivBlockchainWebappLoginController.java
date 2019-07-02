package com.civruralblockchain.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CivBlockchainWebappLoginController {

	@GetMapping("/showCivBlockchainLoginPage")
	public String showCivBlockchainLoginPage() {
		
		//This mapping will return the Login Page of Entourage

		return "CivBlockchainHomePage";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}









