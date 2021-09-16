package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Hospital;
import models.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/patient_activation.do")
public class PatientActivationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String email = request.getParameter("email");
		String activationCode = request.getParameter("activation_code");
		
		if(Patient.activateAccount(email)) {
			 response.sendRedirect("patient_login.do");
		}else
			request.getRequestDispatcher("patient_register.jsp").forward(request,response);
		
	}
}
