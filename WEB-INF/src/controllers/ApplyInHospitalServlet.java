package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Application;
import models.Doctor;
import models.Hospital;

@WebServlet("/apply_in_hospital.do")
public class ApplyInHospitalServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		 
		if(doctor!=null) {
			request.getRequestDispatcher("apply_in_hospital.jsp").forward(request, response);
		}
		else{response.sendRedirect("doctor_login.do");}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		 
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
	 
		if(doctor!=null) {
			 
			if(ServletFileUpload.isMultipartContent(request)) {
				  
				ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> fileItems = null;
				try {
					fileItems = sfu.parseRequest(request);
				}catch(FileUploadException e) {
					e.printStackTrace();
				}
				
				int hospitalId = 0;
				FileItem fileItem = null;
				for(FileItem fileItm :fileItems) {
					if(fileItm.isFormField()) {
						String fieldName = fileItm.getFieldName();
						//System.out.println(fieldName+"   - fieldNames in apply in hospital ");
						if(fieldName.equals("hospital")) {
							hospitalId = Integer.parseInt(fileItm.getString());
							//System.out.println(hospitalId+"  --- hospitalId in apply in hospital");
						}
					}else {
						fileItem = fileItm;
					}
				}
				
				
				
				String fileName = fileItem.getName();
				String uploadFolder = getServletContext().getRealPath("WEB-INF/uploads/doctor/"+doctor.getEmail());
				File file = new File(uploadFolder,fileName);
	  
				try {
					 
					fileItem.write(file);
					 
				}catch(Exception e) {
					e.printStackTrace();
				}
				Application application = new Application();
				application.setDoctorLicenseFile(doctor.getEmail()+"/"+fileName);
				application.setHospital(new Hospital(hospitalId));
				//System.out.println(application.getHospital().getHospitalId()+"   --~@~@!@! hospitalId in apply in hosp");
				application.setDoctor(doctor);
				application.saveApplication();
		 	
			}
			
			request.getRequestDispatcher("apply_in_hospital.jsp").forward(request, response);
		}
		else{response.sendRedirect("doctor_login.do");}
		
		
	}
}
