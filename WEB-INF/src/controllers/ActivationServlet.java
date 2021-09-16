package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Doctor;
import models.Hospital;

import javax.servlet.ServletException;
import java.io.IOException;


public class ActivationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String email = request.getParameter("email");
		//String activationCode = request.getParameter("activation_code");
		int flag = Integer.parseInt(request.getParameter("flag"));
		if(flag==1) {
			if(Doctor.activateAccount(email)) {
				 response.sendRedirect("doctor_login.do");
			}else
				request.getRequestDispatcher("doctor_register.jsp").forward(request,response);
		}
		else if(flag==2) {
			if(Hospital.activateAccount(email)) {
				 response.sendRedirect("index.jsp");
			}else
				request.getRequestDispatcher("hospital_register.jsp").forward(request,response);
		}
		else{
			
		}
		
		
		
	}
}
