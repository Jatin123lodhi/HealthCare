package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Bed;
import models.Hospital;
import models.Patient;

public class AssignRoomBedServlet extends  HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		if(hospital!=null) {
			String bedId = request.getParameter("bed_id");
			 
			if(bedId==null) {
				request.getRequestDispatcher("assign_room_bed.jsp").forward(request, response);
			}else {
			 	
				if(Patient.saveBedNo(Integer.parseInt(bedId), (String)session.getAttribute("patientEmail"))) {
					Bed.changeBedStatus(Integer.parseInt(bedId));
					System.out.println("success");
					response.getWriter().write("successful admitted new patient");
					//response.sendRedirect("hospital_dashboard.do"); 
				}else {
					System.out.println("fali");
					response.getWriter().write("fail--");
				}
				
			}
		}
		else {
			response.sendRedirect("login.do");
		}
	 	 
	}
	
}
