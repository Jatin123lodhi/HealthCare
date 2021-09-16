package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Room;

public class Bed {
	private Integer bedId;
	private Integer bedNo;
	private Room room;
	private BedStatus bedStatus;
	
	public Bed() {
		
	}
	
	public Bed(Integer bedId) {
		super();
		this.bedId = bedId;
	}

	public Bed(Integer bedNo,Room room) {
		this.room = room;
		this.bedNo = bedNo;
	}
	
	public Bed(Integer bedNo,BedStatus bedStatus,Integer bedId) {
		this.bedNo = bedNo;
		this.bedStatus = bedStatus;
		this.bedId = bedId;
	}
	
	//~~~~~~~~~~~~~~~~~~ Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void changeBedStatus(int bedId){
		Connection con = null;
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query =  "update beds set bed_status=2 where bed_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, bedId);
			
			pst.executeUpdate(); 
	 	
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();	
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	 	
		 
	}
	
   	public ArrayList<Bed> getBedsInfo(int roomId){
		Connection con = null;
		ArrayList<Bed> list = new ArrayList<Bed>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query =  "select bed_no,bed_status,bed_id from beds where room_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, roomId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				list.add(new Bed(rs.getInt(1),new BedStatus(rs.getInt(2)),rs.getInt(3) ));
			}
	 	
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();	
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		return list;
	}
	
	
	
	
	
	//~~~~~~~~~~~~~~~~ Getter  Setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}
	
	public Integer getBedId() {
		return bedId;
	}
	
	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
	}
	
	public Integer getBedNo() {
		return bedNo;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Room getRoom() {
		return room;
	}

	public BedStatus getBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(BedStatus bedStatus) {
		this.bedStatus = bedStatus;
	}
	
	
	
	
}
