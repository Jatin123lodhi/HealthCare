package models;

public class PicType {
	private Integer picTypeId;
	private String  picType;
	
	//~~~~~~~~~~~~~~~~ Constructor ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public PicType() {
		super();
	}
	
	public PicType(Integer picTypeId) {
		super();
		this.picTypeId = picTypeId;
	}
	
	public PicType(Integer picTypeId, String picType) {
		super();
		this.picTypeId = picTypeId;
		this.picType = picType;
	}

	//~~~~~~~~~~~~~~~~ Getter  Setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Integer getPicTypeId() {
		return picTypeId;
	}
	public void setPicTypeId(Integer picTypeId) {
		this.picTypeId = picTypeId;
	}
	public String getPicType() {
		return picType;
	}
	public void setPicType(String picType) {
		this.picType = picType;
	}
	
	
}
