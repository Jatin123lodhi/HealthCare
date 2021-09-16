package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Hospital;
import models.Status;
import utils.EmailMessages;
import utils.EmailSender;
import utils.GoogleRecaptcha;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HospitalLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//System.out.println(" doGet ****** ");
		request.getRequestDispatcher("hospital_login.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//System.out.println(" dopost ****** "); 
		String nextPage = "hospital_login.jsp";  
		 String error = "<ul>";
		if(GoogleRecaptcha.recaptchaTest(request)) {
			HttpSession session = request.getSession();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			boolean validation = true;
 
			
			if(!Pattern.matches("^([a-zA-Z][a-zA-Z\\d-_]*)@([a-zA-Z\\d-_]{2,})\\.([a-zA-Z]{2,5})(\\.[a-zA-Z]{2,5})?$", email)) {
				validation = false;
				error += "<li>Enter a valid email </li>";
			}
			

			if(!Pattern.matches("^[a-zA-Z0-9_-]{8,20}$", password)) {
				validation = false;
				error += "<li>Enter a valid password </li>";
			}
			
			 
			
			
			if(validation) {
				 
				Hospital hospital = new Hospital(email,password);
				String resp = hospital.login();
				System.out.println(resp+ " * resp");
				if(resp=="ok") {
					int statusId = hospital.getStatus().getStatusId();
					
					if(statusId==Status.ACTIVE) {
						session.setAttribute("hospital", hospital);
						nextPage = "hospital_dashboard.do"; //"hospital_dashboard.do";
						 
						
					}else if(statusId==Status.INACTIVE) {
						// account inactive show karege 
						
					}else if(statusId==Status.BLOCKED) {
						// same page par accound blocked show karenge
						
					}else if(statusId==Status.ENDED) {
						
						
					}else { // Status.PROFILE_INCOMPLETE
						session.setAttribute("hospital", hospital);
						nextPage = "hospital_profile.do";
						
					}
					
					 
					response.sendRedirect(nextPage);
				}else if(resp=="invalid email") {
					error +="<li>Account doesn't exists with this email </li></ul>";
					request.setAttribute("error",error);
					request.getRequestDispatcher(nextPage).forward(request, response);
				}else if(resp=="incorrect-password") {
					error +="<li>Incorrect Password </li></ul>";
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
