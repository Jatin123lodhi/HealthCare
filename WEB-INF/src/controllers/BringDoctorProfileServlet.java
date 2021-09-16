package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Doctor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/bringDoctorProfile.do")
public class BringDoctorProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		 int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
		 Doctor doctor = new Doctor(doctorId);
		 doctor = doctor.bringDoctorProfileInfo();
		 
		 Gson gson = new Gson();
		 String jsonResp = gson.toJson(doctor);
		 response.getWriter().write(jsonResp);
	}
}
