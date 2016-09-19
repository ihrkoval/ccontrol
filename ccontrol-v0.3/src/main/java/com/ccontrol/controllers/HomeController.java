package com.ccontrol.controllers;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccontrol.DAO.UserDAO;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	@Autowired
	private UserDAO ud;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Date date) {
		date = new Date();
		date.getTime();
		System.out.println("Home page downloaded with success!  Server date & time is: {}." + date);
		
		return "home";
	}
	
	@RequestMapping(value = "/cp", method = RequestMethod.GET)
	public String cp() {
		return "cp";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(@RequestParam("login") String login, 
			@RequestParam("pass") String password) {
		ud.newUser(login, password, "ROLE_USER");
		System.out.println("User "+login + ":"+password+ " was added" );
		
		return "home";
	}
	
}
