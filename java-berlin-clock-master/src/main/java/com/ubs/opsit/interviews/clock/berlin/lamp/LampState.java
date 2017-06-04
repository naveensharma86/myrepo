package com.ubs.opsit.interviews.clock.berlin.lamp;

public enum LampState {
	RED("R"), YELLOW("Y"), OFF("O");
	
	private String state; 
	
	private LampState(final String state) {
		this.state = state;
	}
	
	public String getState() {
		return this.state;
	}
}
