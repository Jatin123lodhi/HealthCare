package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Hospital;

@WebServlet("/bringHospitalRecords.do")
public class BringHosptialRecordsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String srhKey = request.getParameter("key"); 
		ArrayList<Hospital> list =  Hospital.getHospitalRecords(srhKey);
		
		Gson gson = new Gson();
		String jsonResp = gson.toJson(list);
		response.getWriter().write(jsonResp);
		
	}
}
