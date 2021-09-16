package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
	private Integer roomId;
	private Integer roomNo;
	private Integer	bedCount;
	private Integer floorNo;
	
	public Room() {
		super();
	}
	
	public Room(Integer roomNo) {
		this.roomNo = roomNo;
	}
	
	
	public Room(Integer roomId, Integer roomNo, Integer bedCount, Integer floorNo) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.bedCount = bedCount;
		this.floorNo = floorNo;
	}
	
	//~~~~~~~~~~~~~~~~ methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	


	public Integer getRoomId() {
		return roomId;
	}


	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}


	public Integer getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}


	public Integer getBedCount() {
		return bedCount;
	}


	public void setBedCount(Integer bedCount) {
		this.bedCount = bedCount;
	}


	public Integer getFloorNo() {
		return floorNo;
	}


	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}

	
	
	
}
