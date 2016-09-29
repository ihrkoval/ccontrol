package com.ccontrol.controllers.api;

import java.io.IOException;

import javax.persistence.NoResultException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccontrol.DAO.MarkerDAO;
import com.ccontrol.DAO.PhoneDAO;
import com.ccontrol.DAO.UserDAO;
import com.ccontrol.entities.Marker;
import com.ccontrol.entities.Phone;
import com.ccontrol.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping(value = "/api")
public class MobailApi {

	@Autowired 
	UserDAO uDao;
	
	@Autowired 
	PhoneDAO pDao;
	
	@Autowired 
	MarkerDAO mDao;
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT) 
	@ResponseBody 
	public String putMyData(@RequestBody User o) { 
		User tmp;
		try{
			 tmp = uDao.getUserByName(o.getLogin());
			 return "User "+ o.getLogin() + " already exist";
		} catch(NoResultException e) {
			uDao.newUser(o.getLogin(), o.getPassword(), "ROLE_USER");
		}
		
		
	System.out.println("USER PUT "+ o.getLogin()); 
	return "ok"; 
	} 
	
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST) 
	@ResponseBody 
	public String getUser(@RequestBody User o) { 
		
		ObjectMapper mapper = new ObjectMapper();

		try{
		User ru = uDao.getUserByName(o.getLogin());
		
		if(o.getPassword().equals(ru.getPassword())){
			return mapper.writeValueAsString(ru);
		} else {
			return "{\"error\":\"wrong password\"}";
		}
		} catch (NoResultException e){
			e.printStackTrace();
			return "{\"error\":\"incorrect login\"}";
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"error\":\"request error\"}";
		}
		
		
		
	} 
	
	
	
	@RequestMapping(value = "/phone", method = RequestMethod.PUT) //{"id":0,"user":{"login":"pizza","password":"pizza"},"markers":[],"emei":"1321321321","name":"nokla2112"}
	@ResponseBody 
	public String putPhone(@RequestBody Phone p)  { 
				
		try{
			
			User tmp = uDao.getUserByID(p.getUser().getId());
			pDao.phoneAdd(new Phone(tmp, p.getEmei(), p.getName()));

		} catch(NoResultException e) {
			System.out.println(e);
		}
	return "ok"; 
	} 
	
	
	
	@RequestMapping(value = "/marker", method = RequestMethod.PUT) //{"id":0,"user":{"login":"pizza","password":"pizza"},"markers":[],"emei":"1321321321","name":"nokla2112"}
	@ResponseBody 
	public String putMarker(@RequestBody Marker m)  { 
		mDao.addMarker(m);
		
	return "ok"; 
	} 
	
	
}
