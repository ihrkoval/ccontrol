/*package com.rosteach.controllers;
import java.sql.SQLException;

*//**
 * @author Rostislav Pavlenko
 * *//*
import javax.xml.bind.JAXBException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

//import com.rosteach.DAO.InsertionDocInvoice;


@Controller
public class TamperingDataControllerXML {
	
	@RequestMapping(value = "/Push", method = RequestMethod.GET)
	public String insertion(Model model) throws JAXBException{
		String result = "Insertion Successful!!";
		InsertionDocInvoice insertion = new InsertionDocInvoice();
		insertion.insertData();
		model.addAttribute("message",result);
		return "XML";
	}
	@RequestMapping(value = "/Push", method = RequestMethod.GET)
	public ModelAndView insertion(@RequestParam("dataBase") String dataBase,@RequestParam("name") String login,@RequestParam("password") String password) throws JAXBException,SQLException{
		ModelAndView modelAndView = new ModelAndView();
		//InsertionDocInvoice insertion = new InsertionDocInvoice();
		String data="";
		if(dataBase.equals("alter_ros")){
			data="jdbc:firebirdsql:192.168.20.85/3050:alter_ros";
		} else if(dataBase.equals("Alter")){
			data="jdbc:firebirdsql:192.168.20.17/3050:alter";
		} else if(dataBase.equals("alter_curent")){
			data="jdbc:firebirdsql:192.168.20.13/3050:alter_curent";
		}			
			//insertion.insertData(data,login,password);
			String result = "Insertion complete with success!!!\n";
			RedirectView redirectView = new RedirectView("XML");
			redirectView.setStatusCode(HttpStatus.FOUND);
			modelAndView.setView(redirectView);
			modelAndView.addObject("message", result);
		return modelAndView;
	}
}*/