package com.ccontrol.controllers.api;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccontrol.entities.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping(value = "/api")
public class MobailApi {

	
	@RequestMapping(value = "/user", method = RequestMethod.PUT) 
	@ResponseBody 
	public String putMyData(@RequestBody User o) throws JsonParseException, JsonMappingException, IOException { 

		System.out.println(o);
	//User us = new ObjectMapper().readValue(o, User.class); 

	System.out.println("USER PUT "+ o.getLogin()); 
	return "ok"; 
	} 
	
	
}
