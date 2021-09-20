package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Doctor;
@WebServlet("/bringDoctorRecords.do")
public class BringDoctorRecordsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		int cityId = Integer.parseInt(request.getParameter("city_id"));
		int specialityId = Integer.parseInt(request.getParameter("speciality_id"));
		 
		System.out.println(cityId+" "+specialityId);
		
		ArrayList<Doctor> doctors = Doctor.getDoctorRecords(cityId,specialityId);
		
		Gson gson = new Gson();
		String jsonResp = gson.toJson(doctors);
		response.getWriter().write(jsonResp);
	}
	
}
