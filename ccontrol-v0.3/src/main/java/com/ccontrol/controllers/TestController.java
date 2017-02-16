package com.ccontrol.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



public class TestController {
	
	@RequestMapping(value = "/crossdomain.xml", method = RequestMethod.GET)
    @ResponseBody
    public String crossdomain() throws IOException{
					
	    return "<?xml version=\"1.0\"?>\n<cross-domain-policy>\n<allow-access-from domain=\"*\" />\n</cross-domain-policy>";
    }
	
	@RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public String megoggeto(HttpServletRequest request) throws IOException{
		ParseBody pb = new ParseBody();
		pb.getPage(request);	
	    return "ok";
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String test(HttpServletRequest request) throws IOException{
					
	    return "OK!";
    }
}
