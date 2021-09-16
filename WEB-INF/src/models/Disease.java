package models;

public class Disease {
	private Integer disease_id;
	private String disease;
	
	
	public Disease() {
		super();
	}
	public Disease(Integer disease_id, String disease) {
		super();
		this.disease_id = disease_id;
		this.disease = disease;
	}
	
	
	public Integer getDisease_id() {
		return disease_id;
	}
	public void setDisease_id(Integer disease_id) {
		this.disease_id = disease_id;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	
}
