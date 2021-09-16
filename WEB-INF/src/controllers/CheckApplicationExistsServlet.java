package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Application;
import models.Doctor;

@WebServlet("/checkApplicationExists.do")
public class CheckApplicationExistsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
		Application application = new Application(new Doctor(doctorId));
		ArrayList<Application> list = application.checkApplicationExists(); 
			
		Gson gson = new Gson();
		String jsonResp = gson.toJson(list);
		response.getWriter().print(jsonResp);
	}
}
