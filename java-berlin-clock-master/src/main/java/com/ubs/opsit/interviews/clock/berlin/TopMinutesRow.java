package com.ubs.opsit.interviews.clock.berlin;

import java.util.ArrayList;

import com.ubs.opsit.interviews.clock.berlin.lamp.RedLamp;
import com.ubs.opsit.interviews.clock.berlin.lamp.YellowLamp;

public class TopMinutesRow extends AbstractTimeRow {

	public TopMinutesRow() {
		this.lamps = new ArrayList<>(11);
		this.lamps.add(new YellowLamp());
		this.lamps.add(new YellowLamp());
		this.lamps.add(new RedLamp());
		this.lamps.add(new YellowLamp());
		this.lamps.add(new YellowLamp());
		this.lamps.add(new RedLamp());
		this.lamps.add(new YellowLamp());
		this.lamps.add(new YellowLamp());
		this.lamps.add(new RedLamp());
		this.lamps.add(new YellowLamp());
		this.lamps.add(new YellowLamp());
	}
	
	@Override
	public void setTime(final int time) {
		int lampsToBeSwitchedOn = (time - (time % 5)) / 5;
		for(int i = 0; i < lampsToBeSwitchedOn; i++) {
			this.lamps.get(i).switchOn();
		}
	}

}