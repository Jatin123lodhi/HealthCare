package controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Application;
import models.Doctor;
@WebServlet("/cancelApplication.do")
public class CancelApplicationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		 int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
		 String fileName = request.getParameter("file_name");
		 
		 // deleting the file
		 String folderName = getServletContext().getRealPath("/WEB-INF/uploads/doctor/"+fileName);
		 File file = new File(folderName);
		 boolean res = false;
		 if(file.delete()) {
			 Application application = new Application(new Doctor(doctorId));
			 res = application.cancelApplication(); 
		 }
		 
		 
		 
		 
		 response.getWriter().print(res);
		 
	}
}
