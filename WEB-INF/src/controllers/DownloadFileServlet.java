package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadFile.do")
public class DownloadFileServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		
		  String fileName = request.getParameter("file_name");
		  
		  response.setContentType("application/pdf"); 
		  InputStream is =  getServletContext().getResourceAsStream("WEB-INF/uploads/patient/"+fileName);
		  
		  OutputStream os = response.getOutputStream();
		   
		  byte[] arr = new byte[1024]; 
		  while(is.read(arr)!=-1) 
		  { 
			  os.write(arr); 
		  }
	
		  os.flush();
		  os.close();
	 	 
	}
}
