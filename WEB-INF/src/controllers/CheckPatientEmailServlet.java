package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException; 

 
import models.Patient;

public class CheckPatientEmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String email = request.getParameter("email");
		boolean emailExists = Patient.checkEmail(email);
		response.getWriter().print(emailExists);
	}
}
