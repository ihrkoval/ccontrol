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
import com.ccontrol.DAO.PhoneDAO;
import com.ccontrol.DAO.UserDAO;
import com.ccontrol.entities.Marker;
import com.ccontrol.entities.Phone;
import com.ccontrol.entities.User;
import com.ccontrol.security.GetCurrentUser;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	@Autowired
	private UserDAO ud;
	
	@Autowired
	private MarkerDAO md;
	
	@Autowired
	private PhoneDAO pd;
	
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
		try{ 
		User user  = ud.getUserByName(new GetCurrentUser().getUserName());
		
		List<Phone> phons = user.getPhones();
		
		///////get markers with date
		List<Marker> markersList = new ArrayList<Marker>(); //md.getMarkers(p, new Date(2016, 9, 22));
		for (Phone ph : phons){
			List<Marker> ms = md.getMarkers(ph, new Date(2016, 9, 22)); 
			markersList.addAll(ms);
			System.out.println(markersList.size());
		}
		
		
		JSONArray markers = new JSONArray();
		int i = 1;
		StringBuilder sb = new StringBuilder();
		for(Marker m : markersList){
			JSONArray b = new JSONArray();
			b.put(m.getTime());
			b.put(Double.valueOf(m.getLat()));
			b.put(Double.valueOf(m.getLng()));
			b.put(i);
			markers.put(b);
			i++;
		}
		mav.addObject("markers", markers);
		
		//put username to modelAndView
		mav.addObject("login", user.getLogin());
		
		/////get user phones 
		List<Phone> phones = pd.getUserPhones(user);
		JSONArray phonesJ = new JSONArray();
		for(Phone ph : phones){
			phonesJ.put(ph.getName());
		}
		System.out.println(phonesJ.toString());
		mav.addObject("phones", phonesJ);
		
		}catch(ClassCastException e){
			e.printStackTrace();
			return new ModelAndView("home");
		} catch (IndexOutOfBoundsException e){
			System.out.println("User has no phone");
		}
		
		
		return mav;
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(@RequestParam("login") String login, 
			@RequestParam("pass") String password) {
		ud.newUser(login, password, "ROLE_USER");
		System.out.println("User "+login + ":"+password+ " was added" );
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		TransportClient transportClient = HttpTransportClient.getInstance(); 
		VkApiClient vk = new VkApiClient(transportClient); 
		
		return "home";
	}
	
}
