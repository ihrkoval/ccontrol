/*package com.rosteach.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	@RequestMapping(value = "/AjaxExmpl", method = RequestMethod.GET)
	public String ajaxExmpl(Date date) {
		date = new Date();
		date.getTime();
		logger.info("AjaxDataExmpl page downloaded with success!  Server date & time is: {}.",date);
		return "AjaxDataExmpl";
	}
	@RequestMapping(value = "/ajaxTest", method = RequestMethod.GET, produces = { "text/html; charset=UTF-8" })
	public @ResponseBody String ajax(@RequestParam String name) {
		return "Hello Ajax:"+name;
	}
}*/