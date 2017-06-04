package com.ubs.opsit.interviews.clock.berlin;

import java.util.List;

import com.ubs.opsit.interviews.clock.berlin.lamp.Lamp;

public abstract class AbstractTimeRow implements TimeRow {
	
	protected List<Lamp> lamps;
	
	@Override
	public List<Lamp> getLamps() {
		return this.lamps;
	}
	
	public void encodeTime(String time) {
		switchOffAllLamps();
		setTime(Integer.parseInt(time));
	}
	
	private void switchOffAllLamps() {
		for(int i = 0; i < this.lamps.size(); i++) {
			this.lamps.get(i).switchOff();
		}
	}

	abstract protected void setTime(final int time);
}
