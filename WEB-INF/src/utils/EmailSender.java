package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	public static void sendEmail(String email,String subject,String message) {
		Properties properties = new Properties();
		
		properties.put("mail.transport.protocol","smtp");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.starttls.enable","true");
		
		Session session = Session.getInstance(properties,new MailAuthenticator());
		
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			mimeMessage.setFrom("monu99299kumar@gmail.com");
			
			mimeMessage.setRecipients(Message.RecipientType.TO, email);
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(message,"text/html");
			
			Transport.send(mimeMessage);
			
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	 	
	}
}

class MailAuthenticator extends Authenticator{
	public PasswordAuthentication getPasswordAuthentication() {
		
		return new PasswordAuthentication("monu99299kumar@gmail.com","monu99299");
	}
}


