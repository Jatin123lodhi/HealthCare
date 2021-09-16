package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.City;
import models.Hospital;

public class HospitalProfileServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession(); 
		 
		
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		if(hospital==null)
			 response.sendRedirect("hospital_login.do");
		else 
			request.getRequestDispatcher("hospital_profile.jsp").forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		HttpSession session = request.getSession();
		String nextPage = "hospital_login.do";
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		if(hospital!=null) {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			City city = new City(Integer.valueOf(request.getParameter("city")));
			String contactNo = request.getParameter("contact_no");
			Date startDate = Date.valueOf(request.getParameter("start_date")); // String date ko sql date me convert karo 
			String address = request.getParameter("address");
			
			
			if(hospital.updateProfile(name,description,contactNo,city,startDate,address)) {
				nextPage = "index.jsp";
				hospital.setName(name);
				hospital.setDescription(description);
				hospital.setCity(city);
				hospital.setContactNo(contactNo);
				hospital.setStartDate(startDate);
				hospital.setAddress(address);
			}else {
				
				System.out.println("Profile not updated");
			}
			
			
		}
		response.sendRedirect(nextPage);
		
	}
}


//abhi bhi session me value saved ha yhan nahi bhi kar ho to and name me show ho rahi ha , but page refresh karne par
//remove ho jati ha to we have to getSession here