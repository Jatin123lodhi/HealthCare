package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.Admission;
import models.Hospital;
import models.Patient;

public class CollectPatientRecordsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//HttpSession session  = request.getSession();
		//Hospital hospital = (Hospital)session.getAttribute("hospital");
	
		//if(hospital!=null) {
			String key = request.getParameter("key");
			ArrayList<Patient> patients = Patient.collectPatientRecords(key);
			 
			
			
			Gson gson = new Gson();
			String jsonResp = gson.toJson(patients);
			//System.out.println(jsonResp +" %%%%%%%%%");
			
			response.getWriter().print(jsonResp);
		 
		//}else {
		//	System.out.println("hospital- "+hospital);
		//}
	}
}
