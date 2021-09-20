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

import models.Doctor;
@WebServlet("/doctor_logo_upload.do")
public class DoctorLogoUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		
		if(doctor!=null && ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			try {
				List<FileItem> items = sfu.parseRequest(request);
				FileItem fileItem = items.get(0);
				String fileName = doctor.getEmail()+"/"+fileItem.getName();
				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/hospital/"+fileName);
				File file = new File(uploadPath);
				if(doctor.getLogo()!=null) {
					File delFile = new File(uploadPath+"/"+doctor.getLogo());
					delFile.delete();
				}
				
				try {
					fileItem.write(file);
					doctor.saveLogo(fileName);
					doctor.setLogo(fileName);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}catch(FileUploadException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("doctor is null");
		}
		
	}
}
