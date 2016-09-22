package com.ccontrol.controllers;


import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ccontrol.DAO.MarkerDAO;
import com.ccontrol.DAO.UserDAO;
import com.ccontrol.entities.Marker;
import com.ccontrol.entities.Phone;
import com.ccontrol.entities.User;
import com.ccontrol.security.GetCurrentUser;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	@Autowired
	private UserDAO ud;
	
	@Autowired
	private MarkerDAO md;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Date date) {
		/*date = new Date();
		date.getTime();*/
		System.out.println("Home page downloaded with success!  Server date & time is: {}.");
		
		return "home";
	}
	
	@RequestMapping(value = "/cp", method = RequestMethod.GET)
	public ModelAndView cp() {

		ModelAndView mav = new ModelAndView("cp");
		User user  = ud.getUserByName(new GetCurrentUser().getUserName());
		Phone p = user.getPhones().get(0);
		
		
		List<Marker> markersList = md.getMarkers(p, new Date(2016, 9, 22));
		
		JSONArray markers = new JSONArray();
		int i = 1;
		StringBuilder sb = new StringBuilder();
		for(Marker m : markersList){
			JSONArray b = new JSONArray();
			b.put(m.getTimestamp() + " asd");
			b.put(Double.valueOf(m.getLat()));
			b.put(Double.valueOf(m.getLng()));
			b.put(i);
			markers.put(b);
			i++;
		}

		
		mav.addObject("markers", markers);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(@RequestParam("login") String login, 
			@RequestParam("pass") String password) {
		ud.newUser(login, password, "ROLE_USER");
		System.out.println("User "+login + ":"+password+ " was added" );
		
		return "home";
	}
	
}
