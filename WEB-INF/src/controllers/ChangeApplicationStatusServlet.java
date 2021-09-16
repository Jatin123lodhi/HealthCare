package controllers;

import java.io.IOException;
import models.Application;
import models.ApplicationStatus;
import models.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changeApplicationStatus.do")
public class ChangeApplicationStatusServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		 int applicationId = Integer.parseInt(request.getParameter("application_id"));
		 int applicationStatusId = Integer.parseInt(request.getParameter("application_status_id"));
		 int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
		 int hospitalId = Integer.parseInt(request.getParameter("hospital_id"));
		 //System.out.println(hospitalId+"  -- hosp id");
		 Application application = new Application(applicationId,new ApplicationStatus(applicationStatusId));
		 application.changeApplicationStatus();
		 
		 if(applicationStatusId==2) {
			 Doctor doctor = new Doctor(doctorId);
			 doctor.setAppliedHospital(hospitalId);
			 
		 }
		 
		 response.getWriter().write("Status Changed");
		
	}
}
