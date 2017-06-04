package com.ubs.opsit.interviews.clock.berlin;

import java.util.List;

import com.ubs.opsit.interviews.clock.berlin.lamp.Lamp;

public interface TimeRow {
	public List<Lamp> getLamps();
	public void encodeTime(String time);
}
