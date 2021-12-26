package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Doctor;
import models.DoctorTimeSlot;
import models.SlotStatus;

@WebServlet("/bringAvailableSlots.do")
public class BringAvailableSlotsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		
		SlotStatus s = new SlotStatus(sqlDate,new DoctorTimeSlot(new Doctor(doctorId)));
		ArrayList<SlotStatus> list = s.bringAvailableSlots(sqlDate,new DoctorTimeSlot(new Doctor(doctorId)));
		System.out.println(list);
		
		Gson gson  = new Gson();
		String jsonResp = gson.toJson(list);
		response.getWriter().write(jsonResp);
	}
}
