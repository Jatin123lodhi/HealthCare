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
import models.HospitalPic;
import models.PicType;

public class HospitalPicsUploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		int picTypeId= Integer.parseInt(request.getParameter("pic_type_id"));
				
		
		if(hospital!=null && ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			try {
				List<FileItem> items = sfu.parseRequest(request);
				FileItem fileItem = items.get(0);
				String fileName = fileItem.getName();
				 
				String folderName = HospitalPic.PIC_TYPES[picTypeId-1];
				 
				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/hospital/"+hospital.getEmail()+"/"+folderName);
				
				
				File file = new File(uploadPath,fileName);
				String picPath = hospital.getEmail()+ "/" + folderName + "/" + fileName;
				HospitalPic hospitalPic = new HospitalPic(hospital,new PicType(picTypeId),picPath);				
				try {
					fileItem.write(file);
					System.out.println("!!!!!!");
					hospitalPic.save();
					System.out.println("#########");
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
