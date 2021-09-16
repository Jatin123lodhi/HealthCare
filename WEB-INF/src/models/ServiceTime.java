package models;

public class ServiceTime {
	private Integer serviceTimeId;
	private String serviceTime;
	
	public ServiceTime(Integer serviceTimeId) {
		this.serviceTimeId = serviceTimeId;
	}
	
	public ServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public Integer getServiceTimeId() {
		return serviceTimeId;
	}
	public void setServiceTimeId(Integer serviceTimeId) {
		this.serviceTimeId = serviceTimeId;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	
}
