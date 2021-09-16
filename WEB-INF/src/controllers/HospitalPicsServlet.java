package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Hospital;
import models.HospitalPic;

public class HospitalPicsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		String nextPage = "login.do";
		if(hospital!=null) {
			ArrayList<HospitalPic> hospitalPics = HospitalPic.collectHospitalPics(hospital.getHospitalId());
			request.setAttribute("hospitalPics", hospitalPics); 
			 
			nextPage = "hospital_pics.jsp";
		}
		
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		
	}
}
