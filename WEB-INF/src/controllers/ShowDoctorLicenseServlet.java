package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showDoctorLicense.do")
public class ShowDoctorLicenseServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("application/pdf");
		String fileName = request.getParameter("fileName");
		System.out.println("/WEB-INF/uploads/doctor/"+fileName+" --fileName---");
		
		OutputStream os = response.getOutputStream();
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/doctor/"+fileName);
		 
		byte[] arr = new byte[256];
		
		while(is.read(arr)!=-1) {
			os.write(arr);
		}
		os.flush();
		os.close();
	}
}
