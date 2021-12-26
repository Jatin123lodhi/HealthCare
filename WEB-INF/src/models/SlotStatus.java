package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SlotStatus {
	private int slotStatusId;
	private int slotStatus;
	private Date slotDate;
	private DoctorTimeSlot doctorTimeSlot;
	
	
	public SlotStatus(DoctorTimeSlot doctorTimeSlot) {
		this.doctorTimeSlot = doctorTimeSlot;
	}
	
	public SlotStatus(Date slotDate,DoctorTimeSlot doctorTimeSlot) {
		this.slotDate = slotDate;
		this.doctorTimeSlot = doctorTimeSlot;
	}
	
	//####### Methods ##########################
	public  ArrayList<SlotStatus> bringAvailableSlots(Date slotDate,DoctorTimeSlot doctorTimeSlot) {
		Connection con = null;
		ArrayList<SlotStatus> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select time_slot,doctor_time_slot_id from doctor_time_slots where doctor_id=6 and time_slot not in(\r\n" + 
					"select time_slot from slot_status as s inner join doctor_time_slots as dts\r\n" + 
					"where (s.doctor_time_slot_id=dts.doctor_time_slot_id and dts.doctor_id=? )\r\n" + 
					"AND(s.slot_status=2 AND s.slot_date=?)\r\n" + 
					")";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,doctorTimeSlot.getDoctor().getDoctorId());
			pst.setDate(2, slotDate);
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new SlotStatus(new DoctorTimeSlot(rs.getTime(1),rs.getInt(2))));
			}
			//System.out.println(list+"  list"); 
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//######## Getter Setter ####################
	public int getSlotStatusId() {
		return slotStatusId;
	}
	public void setSlotStatusId(int slotStatusId) {
		this.slotStatusId = slotStatusId;
	}
	public int getSlotStatus() {
		return slotStatus;
	}
	public void setSlotStatus(int slotStatus) {
		this.slotStatus = slotStatus;
	}
	public Date getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}
	public DoctorTimeSlot getDoctorTimeSlot() {
		return doctorTimeSlot;
	}
	public void setDoctorTimeSlot(DoctorTimeSlot doctorTimeSlot) {
		this.doctorTimeSlot = doctorTimeSlot;
	}
	
	
}
