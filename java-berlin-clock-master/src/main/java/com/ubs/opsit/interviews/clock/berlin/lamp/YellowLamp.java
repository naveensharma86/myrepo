package com.ubs.opsit.interviews.clock.berlin.lamp;

public class YellowLamp implements Lamp {

	private LampState state = LampState.OFF;

	@Override
	public void switchOn() {
		this.state = LampState.YELLOW;
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
