package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Patient;

@WebServlet("/patient_dashboard.do")
public class PatientDashboardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Patient patient = (Patient)session.getAttribute("patient");
		String nextPage = "patient_login.do";
		if(patient!=null) {
			nextPage = "patient_dashboard.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		 
	}
}
