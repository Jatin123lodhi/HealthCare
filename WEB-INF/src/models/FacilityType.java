package models;

public class FacilityType {
	private Integer facilityTypeId;
	private String facilityType;
	
	public FacilityType() {
		super();
	}
	

	public FacilityType(Integer facilityTypeId, String facilityType) {
		super();
		this.facilityTypeId = facilityTypeId;
		this.facilityType = facilityType;
	}


	public Integer getFacilityTypeId() {
		return facilityTypeId;
	}
	public void setFacilityTypeId(Integer facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	
	
	
}
