package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Disease;
import models.Doctor;
import models.Bed;
import models.ReleaseStatus;
import models.Patient;

public class Admission {
	private Integer admissionId;
	private Disease disease;
	private Patient patient;
	private Date admissionDate;
	private Integer currentTotalBill;
	private String medicalProblem;
	private Doctor doctor;
	private Bed bed;
	private Date releaseDate;
	private ReleaseStatus releaseStatus;
	
	public Admission(Integer admissionId) {
		this.admissionId = admissionId;
	} 
	
	public Admission(Patient patient) {
		super();
		this.patient = patient;
	}
	
	
	
	
	
	public Admission(Integer admissionId, Patient patient, Bed bed) {
		super();
		this.admissionId = admissionId;
		this.patient = patient;
		this.bed = bed;
	}



	//~~~~~~~~~~~~~~~~~~~~ methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static int bringAdmissionDetails(int patientId) {
		Connection con = null;
		int admissionId = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select admission_id from admissions where patient_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,patientId);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				admissionId = rs.getInt(1);
			}
			
		}catch(SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return admissionId;
	}
	
	
	public void newAdmission() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into admissions (patient_id) value (?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,patient.getPatientId());
			
			pst.executeUpdate();
			
		}catch(SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~ Getter Setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Integer getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Integer admissionId) {
		this.admissionId = admissionId;
	}
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Integer getCurrentTotalBill() {
		return currentTotalBill;
	}
	public void setCurrentTotalBill(Integer currentTotalBill) {
		this.currentTotalBill = currentTotalBill;
	}
	public String getMedicalProblem() {
		return medicalProblem;
	}
	public void setMedicalProblem(String medicalProblem) {
		this.medicalProblem = medicalProblem;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Bed getBed() {
		return bed;
	}
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public ReleaseStatus getReleaseStatus() {
		return releaseStatus;
	}
	public void setReleaseStatus(ReleaseStatus releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	
	
}
