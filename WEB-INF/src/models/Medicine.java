package models;

public class Medicine {
	private Integer medicineId;
	private String medicine;
	
	
	public Medicine() {
		super();
	}


	public Medicine(Integer medicineId, String medicine) {
		super();
		this.medicineId = medicineId;
		this.medicine = medicine;
	}


	public Integer getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}


	public String getMedicine() {
		return medicine;
	}


	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	
	
	
	
}
