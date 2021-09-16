package utils;

import models.Doctor;
import models.Hospital;
import models.Patient;

public class EmailMessages {
	
	public static String getPasswordAndActivationMail(String name,String password,String activationCode,String email) {
		
		 return "<!DOCTYPE html>\r\n" + 
		 		"<html lang=\"en\">\r\n" + 
		 		"<head>\r\n" + 
		 		"    <meta charset=\"UTF-8\">\r\n" + 
		 		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
		 		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
		 		"    <title>Document</title>\r\n" + 
		 		"    <style>\r\n" + 
		 		"\r\n" + 
		 		"    </style>\r\n" + 
		 		"</head>\r\n" + 
		 		"<body>\r\n" + 
		 		"    <div style=\"border: 1px solid rgb(118, 189, 236)\">\r\n" + 
		 		"        <h1 style=\"border: 5px solid rgb(118, 189, 236); padding: 10px;color:rgb(18, 100, 100);margin-top: 0px;\">Hcare Account - Your auto generated Password</h1>\r\n" + 
		 		"        \r\n" + 
		 		"        <h3 style=\"margin: 10px;\">Hello "+name+",</h3>  \r\n" + 
		 		"        <h3 style=\"margin: 5px;\">Your Hcare account password is "+password+".</h3>\r\n" + 
		 		"        <h3 style=\"margin: 5px;\">Click the  <a href=\"http://localhost:8080/hcare/patient_activation.do?email="+email+"&activation_code="+activationCode+"\" >link</a>to activate your account</h3>\r\n" + 
		 		"        \r\n" + 
		 		"    </div>\r\n" + 
		 		"</body>\r\n" + 
		 		"</html>";
	}
	
	
	public static String getAccountActivationMail(Object user) {
		String name = null;
		String email = null;
		String activationCode = null;
		int flag = 0;
		
		if(user instanceof Doctor) {
			Doctor doctor = (Doctor)user;
			name = doctor.getName();
			email = doctor.getEmail();
			activationCode = doctor.getActivationCode();
			flag = 1;
		}
		else if(user instanceof Hospital) {
			Hospital hospital = (Hospital)user;
			name = hospital.getName();
			email = hospital.getEmail();
			activationCode = hospital.getActivationCode();
			flag = 2;
		}else {
			Patient patient = (Patient)user;
			name = patient.getName();
			email = patient.getEmail();
			activationCode = patient.getActivationCode();
			flag = 3;
			
		}
		
		
		return "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    \r\n"
				+ "\r\n"
				+ "    <style>\r\n"
				+ "        #heading{\r\n"
				+ "			font-family: verdana;\r\n"
				+ "			padding: 20px;\r\n"
				+ "			background-color: #13a9cf;\r\n"
				+ "			color: #fff;\r\n"
				+ "			width: 70%;\r\n"
				+ "			margin: 0px auto;\r\n"
				+ "			margin-top: 20px;\r\n"
				+ "			border: 1px solid #13a9cf;\r\n"
				+ "			border-top-right-radius: 5px;\r\n"
				+ "			border-top-left-radius: 5px;\r\n"
				+ "		}\r\n"
				+ "		\r\n"
				+ "		#msg_box{\r\n"
				+ "			font-family: verdana;\r\n"
				+ "			padding: 20px;\r\n"
				+ "            font-size: 20px;\r\n"
				+ "			width: 70%;\r\n"
				+ "			margin: 0px auto;\r\n"
				+ "			margin-bottom: 20px;\r\n"
				+ "			border: 1px solid #13a9cf;\r\n"
				+ "			border-bottom-right-radius: 5px;\r\n"
				+ "			border-bottom-left-radius: 5px;\r\n"
				+ "			padding-left: 40px;\r\n"
				+ "			padding-right: 0px;\r\n"
				+ "			color: #333;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h2 id=\"heading\">ISRDC Jabalpur</h2>\r\n"
				+ "	<div id=\"msg_box\">\r\n"
				+ "		<p>Hi, "+name+"</p>\r\n"
				+ "		<p>\r\n"
				+ "			  Jabalpur Hospital. \r\n"
				+ "			Click over the <a href=\"http://localhost:8080/hcare/activation.do?email="+email+"&activation_code="+activationCode+"&flag="+flag+"\">link</a> to activate your account.\r\n"
				+ "		</p>\r\n"
				+ "		<p>\r\n"
				+ "			Regards<br>\r\n"
				+ "			ISRDC Jabalpur Team\r\n"
				+ "		</p>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
	}

}

