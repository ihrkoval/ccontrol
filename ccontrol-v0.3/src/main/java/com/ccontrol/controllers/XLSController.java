/*package com.rosteach.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// @author Rostislav Pavlenko

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.rosteach.DAO.GetReestrForaVeres;
import com.rosteach.entities.ReestrForaVeresList;

@Controller
public class XLSController {
	private static final Logger logger = LoggerFactory.getLogger(XLSController.class);
	
	@Autowired
	private GetReestrForaVeres getReestr;
	
	@RequestMapping(value = "/XLS", method = RequestMethod.GET)
	public String xls() {
		return "XLS";
	}
	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public ModelAndView excel(@RequestParam("startDate") java.sql.Date startDate, @RequestParam("endDate") java.sql.Date endDate) {
		logger.info("Input parameters: ["+startDate+"], ["+endDate+"]");
		ReestrForaVeresList reestrList = new ReestrForaVeresList();
		reestrList.setReestrList(getReestr.getData(startDate,endDate));
		return new ModelAndView("excelDocument", "reestrList", reestrList);
	}
}
*/