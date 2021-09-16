package utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;

public class GoogleRecaptcha {
	public static boolean recaptchaTest(HttpServletRequest request) throws IOException {
		
		String response = request.getParameter("g-recaptcha-response");
		
		String secretKey = "6LeKxNwaAAAAABOcg1MyICtQHOeTpGwySiKYcJyq";
		
		String requestURL = "https://www.google.com/recaptcha/api/siteverify?secret="+secretKey+"&response="+response;
		
		URL url = new URL(requestURL);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
		outputStream.flush();
		outputStream.close();
		
		int statusCode = con.getResponseCode();
		InputStream inputStream = null;
		
		if(statusCode == HttpURLConnection.HTTP_OK) { 
			inputStream = con.getInputStream();
			
		}else {
			inputStream = con.getErrorStream();
		}
		
		
		JsonReader jsonReader = Json.createReader(inputStream);
		JsonObject jsonObject = jsonReader.readObject();
		
		boolean reCaptchaTestResult = jsonObject.getBoolean("success");
		
		return reCaptchaTestResult;
		
		
	
		 
	}
}
