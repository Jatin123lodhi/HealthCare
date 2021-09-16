package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHospitalPicsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		 
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/hospital/"+request.getParameter("pic_path"));
		
		OutputStream os = response.getOutputStream();
		
		byte[] arr = new byte[256];
		while(is.read(arr)!=-1) {
			os.write(arr);
		}
		
		os.flush();
		os.close();
		
	}
}
