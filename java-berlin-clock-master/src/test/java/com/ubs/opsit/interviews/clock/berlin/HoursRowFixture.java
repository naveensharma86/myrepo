package com.ubs.opsit.interviews.clock.berlin;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.berlin.lamp.Lamp;

public class HoursRowFixture {

    private TopHoursRow topHoursRow;
    private BottomHoursRow bottomHoursRow;
    private String theHour;
    
    @Before
    public void setup() {
    	this.topHoursRow = new TopHoursRow();
    	this.bottomHoursRow = new BottomHoursRow();
    }

    @Test
    public void topHoursRowLampCount() throws Exception {
    	assertThat(this.topHoursRow.getLamps().size()).isEqualTo(4);
    }
    
    @Test
    public void bottomHoursRowLampCount() throws Exception {
    	assertThat(this.bottomHoursRow.getLamps().size()).isEqualTo(4);
    }
    
    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-hours.story")
                .run();
    }

    @When("the hour is $hour")
    public void whenTheTimeIs(String hour) {
        theHour = hour;
    }

    @Then("the top hours row should look like $")
    public void thenTheTopHoursShouldLookLike(String theExpectedTopHoursOutput) {
    	this.topHoursRow.encodeTime(this.theHour);
    	List<Lamp> lamps = this.topHoursRow.getLamps();
    	StringBuilder sb = getLampsState(lamps);
        assertThat(sb.toString()).isEqualTo(theExpectedTopHoursOutput);
    }
    
    @Then("the bottom hours row should look like $")
    public void thenTheBottomHourShouldLookLike(String theExpectedBottomHoursOutput) {
    	this.bottomHoursRow.encodeTime(this.theHour);
    	List<Lamp> lamps = this.bottomHoursRow.getLamps();
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