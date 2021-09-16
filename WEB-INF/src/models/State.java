package models;

public class State {
	private Integer stateId;
	private String state;
	
	
	// Constructors 
	public State() {
		super();
	}
	 
	public State(Integer stateId, String state) {
		super();
		this.stateId = stateId;
		this.state = state;
	}
	//Getter Setter methods
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
