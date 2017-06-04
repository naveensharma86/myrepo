package com.ubs.opsit.interviews.clock.berlin;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.berlin.lamp.Lamp;

public class SecondsRowFixture {

    private SecondsRow secondsRow;
    private String theSecond;
    
    @Before
    public void setup() {
    	this.secondsRow = new SecondsRow();
    }

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-seconds.story")
                .run();
    }

    @Test
    public void topMinutesRowLampCount() throws Exception {
    	assertThat(this.secondsRow.getLamps().size()).isEqualTo(1);
    }
    
    @When("the second is $second")
    public void whenTheTimeIs(String second) {
        theSecond = second;
    }

    @Then("the seconds row should look like $")
    public void thenTheTopHoursShouldLookLike(String theExpectedTopHoursOutput) {
    	this.secondsRow.encodeTime(this.theSecond);
    	List<Lamp> lamps = this.secondsRow.getLamps();
    	StringBuilder sb = getLampsState(lamps);
        assertThat(sb.toString()).isEqualTo(theExpectedTopHoursOutput);
    }
    
	private StringBuilder getLampsState(List<Lamp> lamps) {
		StringBuilder sb = new StringBuilder();
    	for (Lamp lamp : lamps) {
    		sb.append(lamp.getLampState().getState());
    	}
		return sb;
	}
}