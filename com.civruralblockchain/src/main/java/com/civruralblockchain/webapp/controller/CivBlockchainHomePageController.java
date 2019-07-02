package com.civruralblockchain.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CivBlockchainHomePageController {

        //Add request to map the main Page of the webapp(isWorking=True)
	@GetMapping("/")
	public String showCivBlockchainHomePage() {
		
		return "CivBlockchainHomePage";
	}
        
        //Add request to map the registration Page of the Users(isWorking=True)
        @GetMapping("/registration")
        public String showCivBlockchainRegisterPage() {
            
            //Return the registration form
            return "CivBlockchainLoginPage";
        }
        
        
        //Adding the mapping for all connected user(isWorking=True)
        @GetMapping("/connectedUser")
        public String showCivBlockchainConnectedUser() {
            return "CivBlockchainConnectedUserMainPage";
        }
        
       
	
}










