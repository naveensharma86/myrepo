package com.ubs.opsit.interviews.clock.berlin;

import java.util.ArrayList;

import com.ubs.opsit.interviews.clock.berlin.lamp.RedLamp;

public class TopHoursRow extends AbstractTimeRow {

	public TopHoursRow() {
		this.lamps = new ArrayList<>(4);
		for(int i = 0; i < 4; i++) {
			this.lamps.add(new RedLamp());
		}
	}
	
	@Override
	public void setTime(final int time) {
		int lampsToBeSwitchedOn = (time - (time % 5)) / 5;
		for(int i = 0; i < lampsToBeSwitchedOn; i++) {
			this.lamps.get(i).switchOn();
		}
	}

}
