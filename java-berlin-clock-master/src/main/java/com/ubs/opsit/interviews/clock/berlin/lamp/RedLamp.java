package com.ubs.opsit.interviews.clock.berlin.lamp;

public class RedLamp implements Lamp {
	
	private LampState state = LampState.OFF;

	@Override
	public void switchOn() {
		this.state = LampState.RED;
	}

	@Override
	public void switchOff() {
		this.state = LampState.OFF;
	}

	@Override
	public LampState getLampState() {
		return this.state;
	}
}
