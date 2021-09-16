package models;

public class BedStatus {
	private Integer bedStatusId;
	private String bedStatus;
	
	public BedStatus(Integer bedStatusId) {
		super();
		this.bedStatusId = bedStatusId;
	}
	
	
	
	// ~~~~~~~~~~~~~~~~ getter setters  ~~~~~~~~~~~~~~~~~~~~
	
	
	public Integer getBedStatusId() {
		return bedStatusId;
	}
	public void setBedStatusId(Integer bedStatusId) {
		this.bedStatusId = bedStatusId;
	}
	public String getBedStatus() {
		return bedStatus;
	}
	public void setBedStatus(String bedStatus) {
		this.bedStatus = bedStatus;
	}
	
	
}
