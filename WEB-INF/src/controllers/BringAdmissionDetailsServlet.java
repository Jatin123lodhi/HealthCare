package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Admission;

@WebServlet("/bring_admission_details.do")
public class BringAdmissionDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		//System.out.println(request.getParameter("patient_id")+" - patient_id");
		int patientId = Integer.parseInt(request.getParameter("patient_id"));
		 
		
		int admissionId = Admission.bringAdmissionDetails(patientId);
		
		response.getWriter().print(admissionId);
		
	}
}
