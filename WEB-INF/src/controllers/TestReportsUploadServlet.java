package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Admission;
import models.Patient;
import models.Test;
import models.TestType;

@WebServlet("/test_report_upload.do")
public class TestReportsUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		
		String patientEmail = request.getParameter("email");
		int admissionId  = Integer.parseInt(request.getParameter("admission_id"));
		Date date =  Date.valueOf(request.getParameter("date"));
		int testTypeId = Integer.parseInt(request.getParameter("test_type_id"));
		System.out.println(patientEmail+"  -patientEmail$$$ "+ admissionId+" -admissId%%% "+date+" -date### "+testTypeId+" -testTypeId");
		
		if (ServletFileUpload.isMultipartContent(request))
		{	
			 
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			List<FileItem> fileItems = null;
			try
			{
				fileItems = sfu.parseRequest(request);
			}
			catch (FileUploadException e)
			{
				e.printStackTrace();
			}

			FileItem fileItem = fileItems.get(0);
			String fileName = fileItem.getName();
			String uploadFolder = getServletContext().getRealPath("/WEB-INF/uploads/patient/"+patientEmail);
			File file = new File(uploadFolder,fileName);
			System.out.println(patientEmail+"/"+fileName+"  fileName");
			try
			{
				fileItem.write(file);
				Test test = new Test(new Admission(admissionId),new TestType(testTypeId),date,patientEmail+"/"+fileName);
				test.saveTestReportDetails();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
