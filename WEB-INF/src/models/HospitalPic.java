package models;

import models.Hospital;
import models.PicType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class HospitalPic {
	
	private Integer hospitalPicId;
	private Hospital hospital;
	private PicType picType;
	private String picPath;
	
	public static final String[] PIC_TYPES = {"interior","exterior","parking","rooms","ot","reception"};
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Integer getHospitalPicId() {
		return hospitalPicId;
	}
	
	public HospitalPic(String picPath,PicType picType) {
		super();
		this.picType = picType;
		this.picPath = picPath;
	}

	public HospitalPic(Hospital hospital, PicType picType, String picPath) {
		super();
		this.hospital = hospital;
		this.picType = picType;
		this.picPath = picPath;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	public static ArrayList<HospitalPic> collectHospitalPics(Integer hospitalId){
		ArrayList<HospitalPic> list = new ArrayList<HospitalPic>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select pic_path,pic_type_id from hospital_pics where hospital_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, hospitalId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new HospitalPic(rs.getString(1),new PicType(rs.getInt(2))));
			}
			
			
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		 
		return list;
	}
	
	
	public void save() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "insert into hospital_pics (hospital_id,pic_type_id,pic_path) values (?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, hospital.getHospitalId());
			pst.setInt(2, picType.getPicTypeId());
			pst.setString(3, picPath);
			
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
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Getter Setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	
	public void setHospitalPicId(Integer hospitalPicId) {
		this.hospitalPicId = hospitalPicId;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public PicType getPicType() {
		return picType;
	}
	public void setPicType(PicType picType) {
		this.picType = picType;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	
}
