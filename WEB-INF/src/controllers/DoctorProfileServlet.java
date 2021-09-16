package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.City;
import models.Doctor;
import models.ServiceTime;

@WebServlet("/doctor_profile.do")
public class DoctorProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		String nextPage = "doctor_login.do";
		if(doctor!=null) {
			request.getRequestDispatcher("doctor_profile.jsp").forward(request,response);
		}else {
			response.sendRedirect(nextPage);
		}
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		
		
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		String nextPage = "doctor_login.do";
		if(doctor!=null) {
			String name = request.getParameter("name");
			int serviceTimeId = Integer.parseInt(request.getParameter("service_time"));
			String contact = request.getParameter("contact");
			String gender = request.getParameter("gender");
			int cityId = Integer.parseInt(request.getParameter("city"));
			String specialization = request.getParameter("specialization");
			String experience = request.getParameter("experience");
			String address = request.getParameter("address");
			//System.out.println(name+" "+serviceTimeId+" "+contact+" "+gender+" "+request.getParameter("city")+" "+specialization+" "+experience+" "+address);
			if(doctor.updateProfile(name,serviceTimeId,contact,gender,cityId,specialization,experience,address)) {
				nextPage = "doctor_profile.do";
				doctor.setName(name);
				doctor.setServiceTime(new ServiceTime(serviceTimeId));
				doctor.setGender(gender);
				doctor.setCity(new City(cityId));
				doctor.setSpecialization(specialization);
				doctor.setExperience(experience);
				doctor.setAddress(address);
			}
			
			
		
		response.sendRedirect(nextPage);
		 
		}	
	}
}
