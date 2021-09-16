package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestType {
	private Integer testTypeId;
	private String testType;
	
	
	public TestType() {
		super();
	}
	public TestType(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}
	public TestType(String testType) {
		this.testType = testType;
	}


	public TestType(Integer testTypeId, String testType) {
		super();
		this.testTypeId = testTypeId;
		this.testType = testType;
	}
	//--------------------- Methods ---------------------------------------------
	
	public static ArrayList<String> collectTestTypesRecords(){
		Connection con = null;
		ArrayList<String> testTypes = new ArrayList<String>();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			String query = "select test_type from test_types";
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				testTypes.add(rs.getString(1));
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
		
		
		return testTypes;
	}
	
	
	
	

	//--------------------- Getter Setters ---------------------------------------
	public Integer getTestTypeId() {
		return testTypeId;
	}


	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}


	public String getTestType() {
		return testType;
	}


	public void setTestType(String testType) {
		this.testType = testType;
	}
	
	
}
