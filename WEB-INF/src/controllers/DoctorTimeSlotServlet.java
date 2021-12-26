package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Doctor;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet; 
 
@WebServlet("/doctor_time_slot.do")
public class DoctorTimeSlotServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		if(doctor!=null){
			request.getRequestDispatcher("doctor_time_slot.jsp").forward(request,response);
		}else {
			response.sendRedirect("doctor_login.do");
		}
		
	}
}
