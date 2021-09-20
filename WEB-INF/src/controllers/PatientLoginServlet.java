package controllers;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Hospital;
import models.Patient;
import models.Status;
import utils.GoogleRecaptcha;
@WebServlet("/patient_login.do")
public class PatientLoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		request.getRequestDispatcher("patient_login.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String nextPage = "patient_login.jsp";  
		 String error = "<ul>";
		if(GoogleRecaptcha.recaptchaTest(request)) {
			HttpSession session = request.getSession();
			
			String email = request.getParameter("email");
			 
			String password = request.getParameter("password");
		 
			System.out.println(email+" ^^^"+password);
			boolean validation = true;

			
			if(!Pattern.matches("^([a-zA-Z][a-zA-Z\\d-_]*)@([a-zA-Z\\d-_]{2,})\\.([a-zA-Z]{2,5})(\\.[a-zA-Z]{2,5})?$", email)) {
				validation = false;
				error += "<li>Enter a valid email </li>";
			}
			

			if(!Pattern.matches("^[a-zA-Z0-9_-]{6,20}$", password)) {
				validation = false;
				error += "<li>Enter a valid password </li>";
			}
			
			 
			
			
			if(validation) {
				 
				Patient patient = new Patient(email,password);
				String resp = patient.login();
				if(resp=="ok") {
					int statusId = patient.getStatus().getStatusId();
					
					if(statusId==Status.ACTIVE) {
						session.setAttribute("patient", patient);
						nextPage = "patient_dashboard.do";  
						 
						
					}else if(statusId==Status.INACTIVE) { // status id  = 2 
						// account inactive show karege 
						error += "<li>Activate your account</li>";
						nextPage = "patient_login.do";
						
					}else if(statusId==Status.BLOCKED) {
						// same page par accound blocked show karenge
						
					}else if(statusId==Status.ENDED) {
						
						
					}else { // Status.PROFILE_INCOMPLETE
						session.setAttribute("patient", patient);
						nextPage = "patient_profile.do";
						
					}
				 
					response.sendRedirect(nextPage);
				}else if(resp=="invalid email") {
					error +="<li>Account doesn't exists with this email </li></ul>";
					request.setAttribute("error",error);
					request.getRequestDispatcher(nextPage).forward(request, response);
				}else if(resp=="incorrect password") {
					error +="<li>Invalid Password </li></ul>";
					request.setAttribute("error",error);
					request.getRequestDispatcher(nextPage).forward(request, response);
				}  
				
			}
			else {
				error += "</ul>";
				request.setAttribute("error",error);
				request.getRequestDispatcher(nextPage).forward(request, response);
			}
		}else {
			error +="<li>Recaptcha Test  Failed </li></ul>";
			request.setAttribute("error",error);
			request.getRequestDispatcher(nextPage).forward(request, response);
			//boot attack page , recaptcha failed
		}
			
	
	
	}
	
}
