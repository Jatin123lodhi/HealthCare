package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.TestType;
@WebServlet("/collectTestTypesRecords.do")
public class CollectTestTypesRecordsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		 
		ArrayList<String> testTypes = TestType.collectTestTypesRecords();
		
		Gson gson = new Gson();
		String jsonResp = gson.toJson(testTypes);
		//System.out.println(jsonResp +" --- jsonResp");
		response.getWriter().write(jsonResp);
	}
}
