package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHospitalLogoServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String logo = request.getParameter("logo");
	 
		System.out.println(logo+"  ** "); 
		OutputStream os = response.getOutputStream();
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/hospital/"+logo);
		if(is==null) {
			is = getServletContext().getResourceAsStream("/static/images/uploadLogo.png");
		}
		
		 
		byte[] arr = new byte[256];
		
		while((is.read(arr))!=-1) {
			os.write(arr);
		}
		
		os.flush();
		os.close();
	}
}
