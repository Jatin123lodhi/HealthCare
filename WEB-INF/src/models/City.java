package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.State;
public class City {
	private Integer cityId;
	private String city;
	private State state;
	
	//################  Constructors ########################3
	public City() {
		super();
	}
	
	public City(Integer cityId) {
		this.cityId = cityId;
		
	}
	
	public City(String city) {
		this.city = city;
	}
	
	public City(Integer cityId, String city) {
		super();
		this.cityId = cityId;
		this.city = city;
	}


	public City(Integer cityId, String city, State state) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.state = state;
	}
	
	// #################  Methods ####################33
	
	public static ArrayList<City> getAllCities(){
		ArrayList<City> cities = new ArrayList<City>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare?user=root&password=1234");
			
			String query = "select city_id,city,s.state_id,s.state from cities as c inner join states as s where c.state_id=s.state_id";
			PreparedStatement pst = con.prepareStatement(query); // java.sql.PreparedStatement;
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				City city = new City(rs.getInt(1),rs.getString(2),new State(rs.getInt(3),rs.getString(4)));
				cities.add(city);
			}
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return cities;
	}
	
	
	
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
	
	
}
