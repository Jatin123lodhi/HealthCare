package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.City;
import models.Patient;

public class UpdatePatientRecordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		String bloodGroup = request.getParameter("bloodGroup");
		 
		
		int city_id = Integer.parseInt(request.getParameter("city_id"));
		//int city_id = 1;
		Patient patient = new Patient(gender, name, email, contact, address, new City(city_id), bloodGroup, weight, height);
		if(patient.update()) {
			response.getWriter().print("updated");
		}else {
			System.out.println("not updated");
			response.getWriter().print("not updated");
		}
		
	}
}
