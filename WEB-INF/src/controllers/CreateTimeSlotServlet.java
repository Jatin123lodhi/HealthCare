package controllers;

import java.io.IOException;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Doctor;
import models.DoctorTimeSlot;
@WebServlet("/create_time_slot.do")
public class CreateTimeSlotServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException  {
		String timeSlot = request.getParameter("slot_time");
		int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
		//System.out.println(timeSlot+" %%%%% "+doctorId);
		 
		
		DoctorTimeSlot dts = new DoctorTimeSlot(Time.valueOf(timeSlot+":00"),new Doctor(doctorId));
		boolean res = dts.addTimeSlot();
		
		response.getWriter().write(Boolean.toString(res));
		
		
	}
}
