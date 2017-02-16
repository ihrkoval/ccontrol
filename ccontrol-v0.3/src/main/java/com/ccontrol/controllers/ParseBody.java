package com.ccontrol.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ResourceUtils;
import org.springframework.web.context.ServletContextAware;

public class ParseBody implements ServletContextAware{
	ServletContext servletContext;
	FileWriter fw;
	public String getPage(HttpServletRequest request) throws IOException{
		String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;
	    

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    parse(body);
	    return body;
	}
	
	private void parse(String body){
		int index = body.indexOf("user = {\"is_authenticated\":true,\"data\"");
		int indexEnd = body.indexOf("defaultDomain = 'megogo.net',");
		String id = body.substring(index, indexEnd);
		System.out.println(id);
		try {
			save(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save(String s) throws IOException{
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		File file = new File("tmp/testfile.txt");
		System.out.println(file.getAbsolutePath());
		
		try{
		fw = new FileWriter(file, true);
		} catch (FileNotFoundException e){
			file.getParentFile().mkdirs();
			file.createNewFile();
			fw = new FileWriter(file, true);
		}
		fw.write(s+"/n/n");
		fw.close();
	}
	
	 @Override
	    public void setServletContext(ServletContext servletContext) {
	        this.servletContext = servletContext;
	    }
}
