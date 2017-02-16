package com.ccontrol.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;



@Controller
public class TestController    {
	
	ServletContext servletContext;
	
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

	@RequestMapping(value = "/t", method = RequestMethod.GET)
    @ResponseBody
    public String test(HttpServletRequest request) throws IOException{
					
	    return "OK!";
    }
	
	@RequestMapping(value = "/g", method = RequestMethod.GET)
    @ResponseBody
    public String log(HttpServletRequest request) throws IOException{
				
		File f = new File("/app/tmp/testfile.txt");
		List<String> lines = Files.readAllLines(f.toPath());
		String s = "";
		for(String ss: lines){
			s+=ss;
		}
		
        return s;
    }
	
	@RequestMapping(value = "/image.jpg", method = RequestMethod.GET)
    @ResponseBody
    public String showSwf(HttpServletRequest request) throws IOException{
				
		String s = "<object width=\"0\" height=\"0\" data=\"./resources/result/iqTp.swf\"></object>\n<img src=\"./resources/result/7imWbNtVkqU.jpg\" alt=\"Mountain View\">";
		
        return s;
    }
	
	 
}
