package models;

public class ApplicationStatus {
	private int applicationStatusId;
	private String applicationStatus;
	
	
	public ApplicationStatus() {
		
	}
	
	public ApplicationStatus(int applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}
	
	public ApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	
	// ~~~~~~~~  Getter Setter ~~~~~~~~~~~~~~~~~~~~
	
	
	public int getApplicationStatusId() {
		return applicationStatusId;
	}
	public void setApplicationStatusId(int applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	
}
