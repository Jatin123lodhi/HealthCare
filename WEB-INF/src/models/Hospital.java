package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;

import models.City;
import models.Status;

public class Hospital {
	
	private Integer hospitalId;
	private String name;
	private String contactNo;
	private String address;
	private String email;
	private String password;
	private City city;
	private String activationCode;
	private Status status;
	private Date startDate;
	private String description;
	private String logo;
	//############### Constructors ##################################
	public Hospital() {
		super();
	}
	
	public Hospital(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public Hospital(Integer hospitalId,String name) {
		this.hospitalId = hospitalId;
		this.name = name;
	}
	
	public Hospital(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Hospital(String name,String email,String password,String activationCode) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.activationCode = activationCode;
	}
	
	public Hospital(int hospitalId,String name,String contactNo,String email,String address,City city,String description,String logo) {
		this.hospitalId = hospitalId;
		this.name = name;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
		this.city = city;
		this.description = description;
		this.logo = logo;
		
	}
	//############### methods #######################################
	public static ArrayList<Hospital> getHospitalRecords(String key) {
		Connection con= null;
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select hospital_id,name,contact_no,email,address,city,description,logo from hospitals as h inner join cities as c where name like '"+key+"%' and h.city_id=c.city_id ";
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				hospitals.add(new Hospital(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),new City(rs.getString(6)),rs.getString(7),rs.getString(8)));
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
		return hospitals;
	}
	
	
	public static ArrayList<Hospital> getHospitalNames() {
		Connection con= null;
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select hospital_id,name from hospitals";
			PreparedStatement pst = con.prepareStatement(query);
			 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				hospitals.add(new Hospital(rs.getInt(1),rs.getString(2)));
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
		return hospitals;
	}
	
	
	public void saveLogo(String fileName) {
		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update hospitals set logo=? where email=?";
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
	
	
	
	public boolean updateProfile(String name,String description,String contactNo,City city,Date startDate,String address) {
		boolean updated = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update hospitals set name=?,description=?,contact_no=?,city_id=?,start_date=?,address=?,status_id=? "
					+ "where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, description);
			pst.setString(3, contactNo);
			pst.setInt(4, city.getCityId());
			pst.setDate(5, startDate);
			pst.setString(6,address);
			pst.setString(7, "1");
			pst.setString(8, email);
			
			
			if(pst.executeUpdate()==1) {
				updated = true;
				
				
			}
			
			con.close();
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();	
		}
		return updated;
	}
	
	
	
	
	
	public String login() {
		String resp = "";
		Connection con = null;   // java.sql.Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");  //java.sql.DriverManager
			
			String query = "select hospital_id,name,contact_no,address,password,status_id,h.city_id,city,description,"
					+ "start_date,logo FROM hospitals AS h INNER JOIN cities AS c where email=? AND h.city_id=c.city_id";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,email);
			
			ResultSet rs  = pst.executeQuery();
			 
			if(rs.next()) {
			 
				String encryptedPassword = rs.getString(5);
				
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor(); // org.jasypt.util.password.StrongPasswordEncryptor
				if(spe.checkPassword(password, encryptedPassword)){
					 
					hospitalId =  rs.getInt(1);
					name = rs.getString(2);
					contactNo = rs.getString(3);
					address = rs.getString(4);
					status = new Status(rs.getInt(6));
					city = new City(rs.getInt(7),rs.getString(8));
					description = rs.getString(9);
					startDate = rs.getDate(10);
					logo = rs.getString(11);
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
	
	
	
	
	public static boolean checkEmail(String email) {
		boolean emailExists = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select * from hospitals where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			
	
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				emailExists = true;
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return  emailExists;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean activateAccount(String email) {
		boolean activate = false;
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update hospitals set status_id=5,activation_code=null where email=?";
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
			String query = "insert into hospitals (name,email,password,activation_code) value (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setString(2,email);
			
			StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
			String encryptedPassword = encryptor.encryptPassword(password);
			
			pst.setString(3,encryptedPassword);
			pst.setString(4, activationCode);
			
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//##### Getter Setter ########################
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLogo() {
		return logo;
	}
	
	
	
	
}
