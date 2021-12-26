package delete_time_slot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DoctorTimeSlot;

@WebServlet("/delete_time_slot.do")
public class DeleteTimeSlotServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int doctorSlotTimeId = Integer.parseInt(request.getParameter("doctor_slot_time_id"));
		DoctorTimeSlot dts = new DoctorTimeSlot(doctorSlotTimeId);
		boolean res = dts.deleteSlot();
		System.out.println(res+"  slot deleted");
		response.getWriter().write(Boolean.toString(res));
	}
}
