package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.Bed;
import models.Room;

public class BedsServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	 
		 
		String roomId = request.getParameter("room_id");
		//System.out.println(roomId+" ^^^^^^");
		Bed bed = new Bed();    // when to make obj and when to make static
	 
	 
		ArrayList<Bed> bedInfo = bed.getBedsInfo(Integer.parseInt(roomId));
		
		request.setAttribute("bedInfo",bedInfo);
		Gson gson = new Gson();
		String json = gson.toJson(bedInfo);
		 
		response.getWriter().write(json);
		 
	}
	
}
