package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Hospital;

public class HospitalLogoUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		
		if(hospital!=null && ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			try {
				List<FileItem> items = sfu.parseRequest(request);
				FileItem fileItem = items.get(0);
				String fileName = hospital.getEmail()+"/"+fileItem.getName();
				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/hospital/"+fileName);
				File file = new File(uploadPath);
				if(hospital.getLogo()!=null) {
					File delFile = new File(uploadPath+"/"+hospital.getLogo());
					delFile.delete();
				}
				
				try {
					fileItem.write(file);
					hospital.saveLogo(fileName);
					hospital.setLogo(fileName);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}catch(FileUploadException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("hospital is null");
		}
		
	}
}
