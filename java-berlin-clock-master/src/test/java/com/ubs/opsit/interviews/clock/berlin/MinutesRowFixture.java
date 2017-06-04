package com.ubs.opsit.interviews.clock.berlin;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.berlin.lamp.Lamp;

public class MinutesRowFixture {

    private TopMinutesRow topMinutesRow;
    private BottomMinutesRow bottomMinutesRow;
    private String theMinutes;
    
    @Before
    public void setup() {
    	this.topMinutesRow = new TopMinutesRow();
    	this.bottomMinutesRow = new BottomMinutesRow();
    }

    @Test
    public void topMinutesRowLampCount() throws Exception {
    	assertThat(this.topMinutesRow.getLamps().size()).isEqualTo(11);
    }
    
    @Test
    public void bottomMinutesRowLampCount() throws Exception {
    	assertThat(this.bottomMinutesRow.getLamps().size()).isEqualTo(4);
    }
    
    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-minutes.story")
                .run();
    }

    @When("the minute is $minute")
    public void whenTheTimeIs(String minute) {
        theMinutes = minute;
    }

    @Then("the top minutes row should look like $")
    public void thenTheTopHoursShouldLookLike(String theExpectedTopHoursOutput) {
    	this.topMinutesRow.encodeTime(this.theMinutes);
    	List<Lamp> lamps = this.topMinutesRow.getLamps();
    	StringBuilder sb = getLampsState(lamps);
        assertThat(sb.toString()).isEqualTo(theExpectedTopHoursOutput);
    }
    
    @Then("the bottom minutes row should look like $")
    public void thenTheBottomHourShouldLookLike(String theExpectedBottomHoursOutput) {
    	this.bottomMinutesRow.encodeTime(this.theMinutes);
    	List<Lamp> lamps = this.bottomMinutesRow.getLamps();
    	StringBuilder sb = getLampsState(lamps);
    	assertThat(sb.toString()).isEqualTo(theExpectedBottomHoursOutput);
    }

	private StringBuilder getLampsState(List<Lamp> lamps) {
		StringBuilder sb = new StringBuilder();
    	for (Lamp lamp : lamps) {
    		sb.append(lamp.getLampState().getState());
    	}
		return sb;
	}
}