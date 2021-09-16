package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Hospital;
import utils.RandomNo;
import utils.SMSSender;

public class SendOtpServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		int otp = 0000;
		if(hospital!=null) {
			String contactNo = request.getParameter("contactNo");
			
			otp = RandomNo.generateOtp();   
			System.out.println(otp);
			//SMSSender.sendOTP(contactNo, "Welcome to our platform. Your otp-"+otp); 
			
			session.setAttribute("otp", otp);
			System.out.println(otp+" --------------------");
		}
		
		response.getWriter().write(otp+"");
		
		
	}
}
