package models;

import models.Hospital;
import models.FacilityType;

public class HospitalFacility {
	
	private Integer hospitalFacilityId;
	private FacilityType facilityType;
	private Hospital hospitalId;
	
	public Integer getHospitalFacilityId() {
		return hospitalFacilityId;
	}
	public void setHospitalFacilityId(Integer hospitalFacilityId) {
		this.hospitalFacilityId = hospitalFacilityId;
	}
	public FacilityType getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}
	public Hospital getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Hospital hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	
}
