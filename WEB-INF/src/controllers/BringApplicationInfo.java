/*
 * package controllers;
 * 
 * import java.io.IOException; import java.util.ArrayList;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.google.gson.Gson;
 * 
 * import models.Application;
 * 
 * @WebServlet("/bringApplicationInfo.do") public class BringApplicationInfo
 * extends HttpServlet{ public void doGet(HttpServletRequest
 * request,HttpServletResponse response)throws ServletException,IOException {
 * System.out.println("!!! bringDoco Lic"); ArrayList<Application> list =
 * Application.bringApplicationInfo(); System.out.println(list+" ---list");
 * 
 * Gson gson = new Gson(); String jsonResp = gson.toJson(list);
 * response.getWriter().write(jsonResp); } }
 */
