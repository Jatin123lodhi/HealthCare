package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Specialization {
	private int specializationId;
	private String specialization;
	
	public Specialization(int specializationId) {
		this.specializationId = specializationId;
	}
	public Specialization(String specialization) {
		this.specialization = specialization;
	}

	public Specialization(int specializationId, String specialization) {
		super();
		this.specializationId = specializationId;
		this.specialization = specialization;
	}
	//~~~~~~~~~~~~~~~~~Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static ArrayList<Specialization> getAllSpecialization(){
		Connection con = null;
		ArrayList<Specialization> specializations = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select * from specializations";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				specializations.add(new Specialization(rs.getInt(1),rs.getString(2)));
			}
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		return specializations;
	}
	
	
	
	//~~~~~~~~~~~~~~~~~~Getter Setter~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}
	
	public int getSpecializationId() {
		return specializationId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
}
