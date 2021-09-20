package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Application {
	private Integer applicationId;
	private Doctor doctor;
	private Hospital hospital;
	private String doctorLicenseFile;
	private ApplicationStatus applicationStatus;
	public Application() {
		
	}
	public Application(Doctor doctor) {
		this.doctor = doctor;
	}

	
	public Application(int applicationId,ApplicationStatus applicationStatus) {
		this.applicationId = applicationId;
		this.applicationStatus = applicationStatus;
	}
	
	public Application(String doctorLicenseFile,Hospital hospital,ApplicationStatus applicationStatus) {
		this.hospital = hospital;
		this.doctorLicenseFile = doctorLicenseFile;
		this.applicationStatus = applicationStatus;
	}
	public Application(int applicationId,Doctor doctor,Hospital hospital,String doctorLicenseFile,ApplicationStatus applicationStatus) {
		this.applicationId = applicationId;
		this.doctor = doctor;
		this.hospital = hospital;
		this.doctorLicenseFile = doctorLicenseFile;
		this.applicationStatus = applicationStatus;
		
	}
	public Application(String doctorLicenseFile,Doctor doctor,int applicationId,Hospital hospital) {
		this.doctorLicenseFile = doctorLicenseFile;
		this.doctor = doctor;
		this.applicationId = applicationId;
		this.hospital = hospital;
	}
	//~~~~~~~~~~~~~~~~ methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public boolean cancelApplication() {
		Connection con = null;
		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "delete from applications where doctor_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,doctor.getDoctorId());
			
			int rowsAff = pst.executeUpdate();
			if(rowsAff!=0) {
				flag = true;
			}
			
			
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return flag; 
	}
	
	
	public ArrayList<Application> checkApplicationExists() {
		Connection con = null;
		ArrayList<Application> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select doctor_license_file,hospital_id,application_status from applications as a inner join application_status as s where doctor_id=? and a.application_status_id=s.application_status_id";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,doctor.getDoctorId());
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				 list.add(new Application(rs.getString(1),new Hospital(rs.getInt(2)),new ApplicationStatus(rs.getString(3))));
			}
			
			
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void changeApplicationStatus() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update applications set application_status_id=? where application_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,applicationStatus.getApplicationStatusId());
			pst.setInt(2, applicationId);
			pst.executeUpdate();
			
			
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public static ArrayList<Application>  bringAllApplications(int hospitalId){
		Connection con = null;
		ArrayList<Application> list = new ArrayList<>();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select doctor_license_file,a.doctor_id,name,email,specialization_id,address,contact_no,experience,city_id,gender,service_time_id,application_id,a.hospital_id from applications as a inner join doctors as d where application_status_id=1 and a.doctor_id=d.doctor_id and a.hospital_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, hospitalId);
			ResultSet rs  = pst.executeQuery();
			while(rs.next()) {
				list.add(new Application(rs.getString(1),new Doctor(rs.getInt(2),rs.getString(3),rs.getString(4),new Specialization(rs.getInt(5)),rs.getString(6),rs.getString(7),rs.getString(8),new City(rs.getInt(9)),rs.getString(10),new ServiceTime(rs.getInt(11))),rs.getInt(12),new Hospital(rs.getInt(13))));
			}
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(list+" ---list");
		return list;
	}
	
	
	/*
	 * public static ArrayList<Application> bringApplicationInfo() { Connection con
	 * = null; //String fileName = ""; ArrayList<Application> list = new
	 * ArrayList<>(); try { Class.forName("com.mysql.cj.jdbc.Driver"); con =
	 * DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
	 * 
	 * String query = "select doctor_license_file,hospital_id from applications";
	 * PreparedStatement pst = con.prepareStatement(query);
	 * 
	 * 
	 * ResultSet rs = pst.executeQuery(); if(rs.next()) { list.add(new
	 * Application(rs.getString(1),new Hospital(rs.getInt(2)))) ; }
	 * 
	 * 
	 * }catch(ClassNotFoundException|SQLException e) { e.printStackTrace(); }finally
	 * { try { con.close(); }catch(SQLException e) { e.printStackTrace(); } } return
	 * list; }
	 */
	
	
	public void saveApplication() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into applications (doctor_license_file,hospital_id,doctor_id) value (?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,doctorLicenseFile);
			pst.setInt(2,hospital.getHospitalId());
			
			pst.setInt(3, doctor.getDoctorId());
			pst.executeUpdate();
			
			
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
 	
	
	//~~~~~~~~ Getter Setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getDoctorLicenseFile() {
		return doctorLicenseFile;
	}

	public void setDoctorLicenseFile(String doctorLicenseFile) {
		this.doctorLicenseFile = doctorLicenseFile;
	}
	
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public ApplicationStatus getApplicationStatus() {
		return  applicationStatus;
	}
	
	
}
