package com.ccontrol.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
		@RequestMapping(value = "/login")
		public String home(Model model) {
			return "login";
		}
		
	


}
