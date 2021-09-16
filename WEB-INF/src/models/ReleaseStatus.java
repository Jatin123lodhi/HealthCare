package models;

public class ReleaseStatus {
	private Integer releaseStatusId;
	private String releaseStatus;
	
	
	public ReleaseStatus() {
		super();
	}
	public ReleaseStatus(Integer releaseStatusId, String releaseStatus) {
		super();
		this.releaseStatusId = releaseStatusId;
		this.releaseStatus = releaseStatus;
	}
	
	
	public Integer getReleaseStatusId() {
		return releaseStatusId;
	}
	public void setReleaseStatusId(Integer releaseStatusId) {
		this.releaseStatusId = releaseStatusId;
	}
	public String getReleaseStatus() {
		return releaseStatus;
	}
	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	
	
	
	
}
