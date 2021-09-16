package models;

import models.Admission;
import models.Test;
import models.Medicine;

public class Pescription {
	private Integer pescriptionId;
	private Medicine medicine;
	private Admission admission;
	private Test test;
	
	
	public Integer getPescriptionId() {
		return pescriptionId;
	}
	public void setPescriptionId(Integer pescriptionId) {
		this.pescriptionId = pescriptionId;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	
	
}
