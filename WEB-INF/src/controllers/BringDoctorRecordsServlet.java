package controllers;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Doctor;
@WebServlet("/bringDoctorRecords.do")
public class BringDoctorRecordsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		int hospitalId = Integer.parseInt(request.getParameter("hospital_id"));
		String speciality = request.getParameter("speciality");
		int serviceTimeId = Integer.parseInt(request.getParameter("service_time_id"));
		System.out.println(hospitalId+" "+speciality+" "+serviceTimeId);
		
		ArrayList<Doctor> doctors = Doctor.getDoctorRecords(hospitalId,speciality,serviceTimeId);
		System.out.println(doctors);
	}
	
}
