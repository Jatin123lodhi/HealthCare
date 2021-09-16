package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Doctor;
import models.Hospital;
import utils.EmailMessages;
import utils.EmailSender;
import utils.GoogleRecaptcha;

public class DoctorRegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("doctor_register.jsp").forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		boolean recaptchaTestResult = GoogleRecaptcha.recaptchaTest(request);
		
		if(recaptchaTestResult) {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			boolean validation = true;

			
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]{2,30}$");
			Matcher matcher = pattern.matcher(name);
			
			String error = "<ul>";
			
			if(!matcher.matches()) {
				validation = false;
				error += "<li>Enter a valid name </li>";
			}
			
			if(!Pattern.matches("^([a-zA-Z][a-zA-Z\\d-_]*)@([a-zA-Z\\d-_]{2,})\\.([a-zA-Z]{2,5})(\\.[a-zA-Z]{2,5})?$", email)) {
				validation = false;
				error += "<li>Enter a valid email </li>";
			}
			

			if(!Pattern.matches("^[a-zA-Z0-9_-]{4,20}$", password)) {
				validation = false;
				error += "<li>Enter a valid password </li>";
			}
			error += "</ul>";
			//System.out.println(error+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			request.setAttribute("error",error);
			
			if(validation) {
				 
				long x = new Random().nextLong();
				if(x<0)
					x *= -1;
				String activationCode = Long.toString(x);
				
				
				Doctor doctor= new Doctor(name,email,password,activationCode);
				doctor.signUp();
				
				ServletContext context = request.getServletContext();
				String parentPath = context.getRealPath("/WEB-INF/uploads/doctor");
				File file = new File(parentPath,doctor.getEmail());
				file.mkdir();
				System.out.println(file+" fileObject ");
				 
				
				String subject = "Doctor account : activation mail";
				
				 
				String message = EmailMessages.getAccountActivationMail(doctor);
				
				EmailSender.sendEmail(doctor.getEmail(),subject,message);
				
				request.getRequestDispatcher("doctor_register_next.jsp").forward(request, response);
				
			}
			else {
				request.getRequestDispatcher("doctor_register.jsp").forward(request, response);
			}
		}else {
			//boot attack page
		}
		
		
		
		
		
		
		
		
		
		 
	}
}
