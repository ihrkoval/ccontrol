/*package com.rosteach.controllers;
*//**
 * @author Rostislav Pavlenko
 * *//*
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class XMLController {

	@RequestMapping(value = "/XML", method = RequestMethod.GET)
	public String xml() {
		return "XML";
	}
	*//**
	 * File upload mapping
	 * *//*
	
	@RequestMapping(value = "/uploadFile", method=RequestMethod.POST)
	@ResponseBody 
	public ModelAndView uploadFile(@RequestParam("file[]") MultipartFile file[]){
		ModelAndView modelAndView = new ModelAndView();
		String fileName = null, result = "";
		String rootPath = "C:/MLW/XMLDOC";
		File directory = new File(rootPath+File.separator+"temp");
		
		if(!directory.exists()){
			directory.mkdirs();
		}
		for (File myFile : new File(rootPath).listFiles()){
			if(myFile.isFile()) 
				myFile.delete();
		}
		for(int i=0;i<=file.length-1;i++){
			try {
				
				byte[] fileBytes = file[i].getBytes();	
				fileName=file[i].getOriginalFilename();
                File newFile = new File(directory.getAbsolutePath() + fileName);
                
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.flush();
                stream.close();
                result+="--Server directory.path: " + rootPath+"\n"+"    File original name: " + file[i].getOriginalFilename()+"\n"+"    File content type: " + file[i].getContentType()+"\n"+"    File is saved under: "+newFile+"\n";
            } 
			catch (Exception e) {
            	e.printStackTrace();
            }
		}
		RedirectView redirectView = new RedirectView("XML");
        redirectView.setStatusCode(HttpStatus.FOUND);
        modelAndView.setView(redirectView);
        modelAndView.addObject("message", result);
		return modelAndView;
    }
}
*/