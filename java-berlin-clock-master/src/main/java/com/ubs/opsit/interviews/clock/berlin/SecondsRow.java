package com.ubs.opsit.interviews.clock.berlin;

import java.util.ArrayList;

import com.ubs.opsit.interviews.clock.berlin.lamp.YellowLamp;

public class SecondsRow extends AbstractTimeRow {
	
	public SecondsRow() {
		super();
		this.lamps = new ArrayList<>(1);
		this.lamps.add(new YellowLamp());
	}

	@Override
	public void setTime(final int time) {
		if(0 == time % 2) {
			this.lamps.get(0).switchOn();
		}
	}

}
