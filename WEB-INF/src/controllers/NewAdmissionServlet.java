package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Admission;
import models.City;
import models.Hospital;
import models.Patient;
import utils.EmailMessages;
import utils.EmailSender;
import utils.RandomNo;

public class NewAdmissionServlet extends  HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		
		String nextPage = "hospital_login.do";
		if(hospital!=null) {
			nextPage = "new_admission.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		String nextPage = "hospital_login.do";
		 
		if(hospital!=null) {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender"); 
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String password = RandomNo.generatePassword();
			String address = request.getParameter("address");
			int city_id = Integer.parseInt(request.getParameter("city"));
			Date dob = Date.valueOf(request.getParameter("dob"));
			String bloodGroup = request.getParameter("blood_group");
			String weight = request.getParameter("weight");
			String height = request.getParameter("height");
			
			/*
			 * boolean validation = true; String error = ""; if(!Pattern.matches(
			 * "^([a-zA-Z][a-zA-Z\\d-_]*)@([a-zA-Z\\d-_]{2,})\\.([a-zA-Z]{2,5})(\\.[a-zA-Z]{2,5})?$",
			 * email)) { validation = false; error += "<li>Enter a valid email </li>"; }
			 * 
			 * if(!Pattern.matches("^[a-zA-Z0-9 ]{2,30}$",name)) { validation = false; error
			 * += "<li>Enter a valid name </li>"; }
			 */
			long x = new Random().nextLong();
			if(x<0)
				x *= -1;
			String activationCode = Long.toString(x);
			
			Patient patient = new Patient(gender,name,email,password,contact,address,new City(city_id),dob,bloodGroup,weight,height);
			int patientId = patient.save(); 
			Admission admission = new Admission(new Patient(patientId));
			admission.newAdmission();
			if(patientId!=-1) {
				nextPage = "assign_room_bed.do";
				session.setAttribute("patientEmail",email);
				//send Email by generating a password and then login karo
				
				ServletContext context = request.getServletContext();
				String parentPath  = context.getRealPath("WEB-INF/uploads/patient");
				String folderName = email;
				File file = new File(parentPath,folderName);
				file.mkdir();
				
				
				String subject = "Hcare: Your Account Password"; 
				String message = EmailMessages.getPasswordAndActivationMail(name,password,activationCode,email);
				EmailSender.sendEmail(email, subject, message);
				
				response.sendRedirect(nextPage);
				
			}else {
				System.out.println(" record not saved");
			}
			
			
			 
		}else {
			response.sendRedirect(nextPage);
		}
		
		
		
	}
}
