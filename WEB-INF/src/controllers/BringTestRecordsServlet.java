package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Admission;
import models.Test;

@WebServlet("/bring_test_records.do")
public class BringTestRecordsServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
 
		
		  int admissionId = Integer.parseInt(request.getParameter("admission_id"));
		  
		  ArrayList<Test> tests = Test.bringTestRecords(admissionId);
		  
		  
		  Gson gson = new Gson(); String jsonResp = gson.toJson(tests);
	 
		  
		  response.getWriter().write(jsonResp);
		 
	}
}
