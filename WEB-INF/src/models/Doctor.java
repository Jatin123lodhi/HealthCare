package models;

import models.Status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;

import models.City;

public class Doctor {
	private Integer doctorId;
	private String name;
	private Specialization specialization;
	private String address;
	private String contactNo;
	private String email;
	private String password;
	private String experience;
	private String profilePic;
	private String activationCode;
	private Status status;
	private City city;
	private String gender;
	private ServiceTime serviceTime;
	private String logo;
	
	
	
	
	//############### Constructors ##################################
	public Doctor() {
		super();
	}
	
	public Doctor(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public Doctor(String email,String password) {
		this.email = email;
		this.password = password;
	}
	
	public Doctor(String name,String email,String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	public Doctor(String name, String email, String password, String activationCode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.activationCode = activationCode;
	}
	
	public Doctor(int doctorId,String name,String email,Specialization specialization,String address,String contactNo,String experience,City city,String gender,ServiceTime serviceTime) {
		this.doctorId = doctorId;
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.address = address;
		this.contactNo = contactNo;
		this.experience = experience;
		this.city = city;
		this.gender = gender;
		this.serviceTime = serviceTime;
	}
	
	public Doctor(String name,String experience,ServiceTime serviceTime,String logo){
		this.name = name;
		this.experience = experience;
		this.serviceTime = serviceTime;
		this.logo = logo;
	}
	//############### methods #######################################
	public void saveLogo(String fileName) {
		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update doctors set logo=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,fileName);
			pst.setString(2, email);
			
			pst.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static ArrayList<City> getDoctorCities() {
		Connection con= null;
		ArrayList<City> cities = new ArrayList<City>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select distinct city,d.city_id from doctors as d inner join cities as c where c.city_id=d.city_id";
			PreparedStatement pst = con.prepareStatement(query);
		 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				cities.add(new City(rs.getString(1)));
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cities;
	}
	
	public void setAppliedHospital(int hospitalId){
		Connection con  = null;
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // classnot found except
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234"); //sql excep
			
			String query = "update doctors set hospital_id=? where doctor_id=?";
			
			PreparedStatement pst = con.prepareStatement(query); // sql exep
			pst.setInt(1,hospitalId);
			pst.setInt(2, doctorId);
			System.out.println(hospitalId+" --hosp id   doc id- "+ doctorId);
			int rows = pst.executeUpdate();
			System.out.println(rows+"  -- rows aff");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	 
	}
	
	
	public Doctor bringDoctorProfileInfo(){
		Connection con  = null;
		Doctor doctor = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // classnot found except
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234"); //sql excep
			
			String query = "select name,email,specialization_id,address,contact_no,experience,city_id,gender,service_time from doctors as d inner join service_times as st where doctor_id=? and d.service_time_id=st.service_time_id";
			
			PreparedStatement pst = con.prepareStatement(query); // sql exep
			pst.setInt(1, doctorId);
			
			ResultSet rs = pst.executeQuery(); // sql excep
			while(rs.next()) { // sql excep
				  doctor = new Doctor(doctorId,rs.getString(1),rs.getString(2),new Specialization(rs.getInt(3)),rs.getString(4),rs.getString(5),rs.getString(6),new City(rs.getInt(7)),rs.getString(8),new ServiceTime(rs.getString(9)));
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return doctor;
	}
	
	
	public static ArrayList<Doctor> getDoctorRecords(int cityId,int specialityId) {
		Connection con= null;
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select name,experience,d.service_time_id,service_time,logo from doctors as d inner join service_times as st where d.service_time_id=st.service_time_id and city_id=? and specialization_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,cityId);
			pst.setInt(2,specialityId);	
		 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				doctors.add(new Doctor(rs.getString(1),rs.getString(2),new ServiceTime(rs.getInt(3),rs.getString(4)),rs.getString(5)));
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return doctors;
	}
	
	public static ArrayList<String> getDoctorSpeciality() {
		Connection con= null;
		ArrayList<String> specialities = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select distinct specialization from doctors";
			PreparedStatement pst = con.prepareStatement(query);
		 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				specialities.add(rs.getString(1));
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return specialities;
	}
	
	public boolean updateProfile(String name, int serviceTimeId, String contact, String gender, int cityId,
		Specialization specialization, String experience, String address) {
		Connection con = null;
		boolean updated = false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String  query = "update doctors set name=?,service_time_id=?,contact_no=?,gender=?,city_id=?,specialization_id=?,experience=?,address=?"
					+ " where doctor_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,name);
			pst.setInt(2,serviceTimeId);
			pst.setString(3,contact);
			pst.setString(4,gender);
			pst.setInt(5,cityId);
			pst.setInt(6, specialization.getSpecializationId());
			pst.setString(7, experience);
			pst.setString(8, address);
			pst.setInt(9, doctorId);
			
			int updatedRow = pst.executeUpdate();
			 
			if(updatedRow==1) {
				updated = true;
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
	 	
		return updated;
	}
	
	
	
	

	public String login() {
		String resp = "";
		Connection con = null;   // java.sql.Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");  //java.sql.DriverManager
			
			String query = "select doctor_id,name,contact_no,address,password,status_id,d.city_id,city,specialization_id,experience,"
					+ "profile_pic,gender,service_time_id,logo FROM doctors AS d INNER JOIN cities AS c where email=? AND d.city_id=c.city_id";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,email);
			
			ResultSet rs  = pst.executeQuery();
			 
			if(rs.next()) {
			 
				String encryptedPassword = rs.getString(5);
				
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor(); // org.jasypt.util.password.StrongPasswordEncryptor
				if(spe.checkPassword(password, encryptedPassword)){
					 
					doctorId =  rs.getInt(1);
					name = rs.getString(2);
					contactNo = rs.getString(3);
					address = rs.getString(4);
					status = new Status(rs.getInt(6));
					city = new City(rs.getInt(7),rs.getString(8));
					specialization = new Specialization(rs.getInt(9));
					experience = rs.getString(10);
					profilePic = rs.getString(11);
					gender = rs.getString(12);
					serviceTime = new ServiceTime(rs.getInt(13));
					logo = rs.getString(14);
					resp = "ok";
				
				}else {
					resp = "incorrect-password";
				}
				 
			}else {
				resp = "invalid email";
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return resp;
	}
	
	
	
	
	
	public static boolean activateAccount(String email) {
		boolean activate = false;
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update doctors set status_id=5,activation_code=null where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, email);
			int rows = pst.executeUpdate();
			if(rows==1) {
				activate = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return activate;
	}
	
	
	public void signUp() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into doctors (name,email,password) value (?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setString(2, email);
			StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
			String encryptedPassword = encryptor.encryptPassword(password);
			pst.setString(3, encryptedPassword);
			
			pst.executeUpdate();
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//##### Getter Setter ########################
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctor_id(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ServiceTime getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(ServiceTime serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	
}
