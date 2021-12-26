package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class DoctorTimeSlot {
	private int doctorTimeSlotId;
	private Time time;
	private Doctor doctor;
	
	public DoctorTimeSlot() {
		
	}
	public DoctorTimeSlot(Doctor doctor) {
		this.doctor = doctor;
	}
	public DoctorTimeSlot(int doctorTimeSlotId) {
		this.doctorTimeSlotId = doctorTimeSlotId;
	}
	public DoctorTimeSlot(Time time,int doctorTimeSlotId) {
		this.time = time;
		this.doctorTimeSlotId = doctorTimeSlotId;
	}
	public DoctorTimeSlot(Time time,Doctor doctor) {
		this.time = time;
		this.doctor = doctor;
	}
	
	//######## method ####################
	
	public boolean deleteSlot() {
		Connection con = null;
	 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "delete from doctor_time_slots where doctor_time_slot_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,doctorTimeSlotId);
			
			
			int rows = pst.executeUpdate();
			if(rows==1) {
				return true;
			}
			 
			 
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<DoctorTimeSlot> bringTimeSlots(int doctorId) {
		Connection con = null;
		ArrayList<DoctorTimeSlot> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select time_slot,doctor_time_slot_id from doctor_time_slots where doctor_id=? order by time_slot asc";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,doctorId);
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new DoctorTimeSlot(rs.getTime(1),rs.getInt(2)));
			}
			//System.out.println(list+"  list"); 
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public boolean addTimeSlot() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into doctor_time_slots (time_slot,doctor_id) values (?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setTime(1,time);
			pst.setInt(2,doctor.getDoctorId());
			
			int rows = pst.executeUpdate();
			if(rows==1) {
				return true;
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	//####### Getter Setters #############
	
	public int getDoctorTimeSlotId() {
		return doctorTimeSlotId;
	}

	public void setDoctorTimeSlotId(int doctorTimeSlotId) {
		this.doctorTimeSlotId = doctorTimeSlotId;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
