package models;

public class Appointment {
	private int appointmentId;
	private String patientName;
	private String patientMobileNo;
	private SlotStatus slotStatus;
	private int appointmentStatus;
	
	
	//##### Getter Setter ############
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientName() {
		return patientName;
	}
	
	public void setPatientMobileNo(String patientMobileNo) {
		this.patientMobileNo = patientMobileNo;
	}
	public String getPatientMobileNo() {
		return patientMobileNo;
	}
	
	public void setSlotStatus(SlotStatus slotStatus) {
		this.slotStatus = slotStatus;
	}
	public SlotStatus getSlotStatus() {
		return slotStatus;
	}
	
	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public int getAppointmentStatus() {
		return appointmentStatus;
	}
}
