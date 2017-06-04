package com.ubs.opsit.interviews.clock.berlin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.clock.berlin.lamp.Lamp;

public class BerlinClockTimeConverter implements TimeConverter {

	/* This timeRows represent 5 lamps rows in Berlin clock in the same order
	 * Index 0 - second's lamps
	 * Index 1 - Top Hours's lamps
	 * Index 2 - Bottom Hour's lamps
	 * Index 3 - Top Minute's lamps
	 * Index 4 - Bottom Minute's lamps
	 * TimeRow is an array of lamps
	*/
	private List<TimeRow> timeRows;
	
	public BerlinClockTimeConverter() {
		this.timeRows = new ArrayList<>(5);
		this.timeRows.add(new SecondsRow());
		this.timeRows.add(new TopHoursRow());
		this.timeRows.add(new BottomHoursRow());
		this.timeRows.add(new TopMinutesRow());
		this.timeRows.add(new BottomMinutesRow());
	}
	
	@Override
	public String convertTime(String aTime) {
		if(isValidDigitalInput(aTime)) {
			this.encodeTime(aTime);
			List<String> timeList = new ArrayList<>();
			for (TimeRow timeRow : this.timeRows) {
				StringBuilder sb = new StringBuilder();
				List<Lamp> lamps = timeRow.getLamps();
				for (Lamp lamp : lamps) {
					sb.append(lamp.getLampState().getState());
				}
				timeList.add(sb.toString());
			}
			return Joiner.on(System.getProperty("line.separator")).join(timeList);
		} else {
			throw new IllegalArgumentException("input time is not correct");
		}
	}

	private void encodeTime(String aTime) {
		String[] split = aTime.split(":");
		String digitalHours = split[0];
		String digitalMinutes = split[1];
		String digitalSeconds = split[2];
		this.encodeHours(digitalHours);
		this.encodeMinutes(digitalMinutes);
		this.encodeSeconds(digitalSeconds);
	}
	//sets seconds in first row of Berlin clock
	private void encodeSeconds(final String digitalSeconds) {
		TimeRow sencondsRow = this.timeRows.get(0);
		sencondsRow.encodeTime(digitalSeconds);
	}
	
	//sets hours in second and third row of Berlin clock
	private void encodeHours(final String digitalHours) {
		TimeRow topHoursRow = this.timeRows.get(1);
		TimeRow bottomHoursRow = this.timeRows.get(2);
		topHoursRow.encodeTime(digitalHours);
		bottomHoursRow.encodeTime(digitalHours);
	}
	
	//sets minutes in fourth and fifth row of Berlin clock
	private void encodeMinutes(final String digitalMinutes) {
		TimeRow topMinutesRow = this.timeRows.get(3);
		TimeRow bottomMinutesRow = this.timeRows.get(4);
		topMinutesRow.encodeTime(digitalMinutes);
		bottomMinutesRow.encodeTime(digitalMinutes);
	}
	
	//validates the digital input time
	protected boolean isValidDigitalInput(final String digitalInput) {
		String pattern = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(digitalInput);
		return matcher.matches();
	}

}
