package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;

import models.City;
import models.Status;

public class Patient {
	private Integer patientId;
	private String gender;
	private	String name;
	private String email;
	private String password;
	private String contactNo;
	private String address;
	private City city;
	private String profilePic;
	private Date dob;
	private String bloodGroup;
	private String weight;
	private String height;
	private String activationCode;
	private Status status;
	private Bed bed;
	private ReleaseStatus releaseStatus;
	
	//~~~~~~~~~~~~~~~~~~~~~~~ Constructor ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Patient() {
		super();
	}
 	
	public Patient(Integer patientId) {
		this.patientId = patientId;
	}
	
	public Patient(String email,String password) {
		this.email = email;
		this.password = password;
	}
	
	public Patient(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	 
	public Patient(String gender, String name, String email, String contactNo, String address,City city ,
			String bloodGroup, String weight, String height ) {
		super();
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.city = city;
		this.bloodGroup = bloodGroup;
		this.weight = weight;
		this.height = height;

	}


	public Patient(String gender, String name, String email, String password, String contactNo, String address,
			City city, Date dob, String bloodGroup, String weight, String height) {
		super();
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.city = city;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.weight = weight;
		this.height = height;
	}

   
	public Patient(Integer patientId, String gender, String name, String email, String password, String contactNo,
			String address, City city, Date dob, String bloodGroup, String weight, String height, Bed bed) {
		super();
		this.patientId = patientId;
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.city = city;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.weight = weight;
		this.height = height;
		this.bed = bed;
	}


	//########## methods #########################################
	
	
	
	 
	
	public static boolean activateAccount(String email) {
		boolean activate = false;
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update patients set status_id=1,activation_code=null where email=?";
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
	
	public String login() {
		String resp= "";
		Connection con = null;   // java.sql.Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");  //java.sql.DriverManager
			
			String query = "select patient_id,name,contact_no,address,password,status_id,p.city_id,city,dob,blood_group,weight,height,bed_no,room_no "
					+ "FROM patients AS p INNER JOIN cities AS c inner join beds as b inner join rooms as r where email=? AND p.city_id=c.city_id and p.bed_id=b.bed_id and b.room_id=r.room_id";
			PreparedStatement pst = con.prepareStatement(query);
		 
			pst.setString(1,email);
			
			ResultSet rs  = pst.executeQuery();
		 
			if(rs.next()) {
				
				String encryptedPassword = rs.getString(5);
				
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor(); // org.jasypt.util.password.StrongPasswordEncryptor
				
				if(spe.checkPassword(password, encryptedPassword)){
				 
					patientId =  rs.getInt(1);
					name = rs.getString(2);
					contactNo = rs.getString(3);
					address = rs.getString(4);
					status = new Status(rs.getInt(6));
					city = new City(rs.getInt(7),rs.getString(8));
					dob = rs.getDate(9);
					bloodGroup = rs.getString(10);
					weight = rs.getString(11);
					height = rs.getString(12);
					bed = new Bed(rs.getInt(13),new Room(rs.getInt(14)));
								
					resp = "ok";
					
					
					
				}else {
					resp = "incorrect password";
				}
				 
			}else {
				resp = "invalid email";
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return resp;
	}
	
	
	
	public  boolean update() {
		Connection con = null;
		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "update patients set gender=?,name=?,contact_no=?,address=?,city_id=?,blood_group=?,weight=?,height=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			 
			pst.setString(1, gender);
			pst.setString(2, name);
			pst.setString(3, contactNo);
			pst.setString(4, address);
			pst.setInt(5, city.getCityId());
			pst.setString(6, bloodGroup);
			pst.setString(7, weight);
			pst.setString(8, height);
			pst.setString(9, email);
			int row = pst.executeUpdate();		 
	 
			if(row==1) {
				flag = true;
			}
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	
	
	public static ArrayList<Patient> collectPatientRecords(String key) {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select patient_id,gender,name,email,password,contact_no,address,city_id,dob,blood_group,weight,height,bed_no,room_no from patients as p inner join beds as b inner join rooms as r where p.bed_id=b.bed_id and b.room_id=r.room_id and (email=? or name like '"+key+"%')";
			PreparedStatement pst = con.prepareStatement(query);
			
	
			pst.setString(1,key);
			 
			ResultSet rs = pst.executeQuery();
			 
			while(rs.next()) {
				patients.add(new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),new City(rs.getInt(8)),rs.getDate(9),rs.getString(10),rs.getString(11),rs.getString(12),new Bed(rs.getInt(13),new Room(rs.getInt(14)))));
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//System.out.println(patients+" $$$$$$");
		
		return  patients;
	}
	
	public static boolean checkEmail(String email) {
		boolean emailExists = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select * from patients where email=?";
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
	
	
	
	public static boolean saveBedNo(int bedId,String email) {
		Connection con = null;
		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // class not found exception
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234"); // SQLException
			
			String query = "update patients set bed_id=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);  // SQLException 
			
			pst.setInt(1, bedId);               // SQLException
			pst.setString(2, email);
			System.out.println(bedId+"  @@@ "+ email + " @@@@ "+ pst );
			int rows = pst.executeUpdate();
			System.out.println(rows+" -- rows ");
			if(rows==1) {
				flag = true;
				System.out.println("@@@ true");
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
		
		return flag;
	}
	
	
	
	public int save() {
		Connection con = null;
		//boolean flag = false;
		int generatedKey = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into patients (gender,name,email,password,contact_no,address,city_id,dob,blood_group,weight,height) value (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, gender);
			pst.setString(2, name);
			pst.setString(3, email);
			
			StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
			String encryptedPassword = encryptor.encryptPassword(password);
			
			pst.setString(4, encryptedPassword);
			pst.setString(5,contactNo);
			pst.setString(6,address);
			pst.setInt(7,city.getCityId());
			pst.setDate(8,dob);
			pst.setString(9,bloodGroup);
			pst.setString(10, weight);
			pst.setString(11,height);
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys(); 
			if(rs.next()){
				generatedKey = rs.getInt(1);
				System.out.println("The generated keys is : "+generatedKey);
				
			}
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return generatedKey;
	}
	
	
	
	
	
	public void signUp() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			String query = "insert into patients (name,email,password) value (?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setString(2,email);
			pst.setString(3,password);
			
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//######## getter setter #################################3
	
	
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
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
	
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	public Bed getBed() {
		return bed;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}

	public ReleaseStatus getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(ReleaseStatus releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	
	 
	
}
