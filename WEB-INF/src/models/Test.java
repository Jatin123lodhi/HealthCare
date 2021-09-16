package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Admission;
import models.TestType;

public class Test {
	private Integer testId;
	private TestType testType;
	private Admission admission;
	private Date date;
	private String fileName;
	 
	public Test(Admission admission, TestType testType,Date date,String fileName) {
		super();
		this.admission = admission;
		this.testType = testType;
		this.date = date;
		this.fileName = fileName;
	}
	public Test(Date date,TestType testType,String fileName) {
		this.date = date;
		this.testType = testType;
		this.fileName = fileName;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	
	public static ArrayList<Test> bringTestRecords(int admissionId) {
		Connection con = null;
		ArrayList<Test> tests = new ArrayList<Test>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select date,test_type,file_name from tests as t inner join test_types as ty where t.test_type_id=ty.test_type_id and admission_id=? order by date";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, admissionId);
			 
			ResultSet rs = pst.executeQuery();
			 
			while(rs.next()) {
				tests.add(new Test(rs.getDate(1),new TestType(rs.getString(2)),rs.getString(3)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return tests;
	}
	
	
	
	public void saveTestReportDetails() {
		 
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into tests (admission_id,date,test_type_id,file_name) values (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, admission.getAdmissionId());
			pst.setDate(2, date);
			pst.setInt(3, testType.getTestTypeId());
			pst.setString(4, fileName);
			int rows = pst.executeUpdate();
			System.out.println(rows +"  -upadated rows ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 
		
	}
		
	
	//~~~~~~~~~~~~~~~~~~~ Getter Setter ~~~~~~~~~~~~~~~~~
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public TestType getTestType() {
		return testType;
	}
	public void setTestType(TestType testType) {
		this.testType = testType;
	}
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
	
	
}
