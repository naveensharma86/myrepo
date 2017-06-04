package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.berlin.BerlinClockTimeConverter;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String theTime;
    
    @Before
    public void setup() {
    	this.berlinClock = new BerlinClockTimeConverter();
    }

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }
    
    @Then("the clock should throw error $")
    public void thenTheClockShouldThrowError(String errorMessage) {
    	try {
    		berlinClock.convertTime(theTime);
    		Assertions.fail("assert error");
    	} catch(Exception e) {
    		assertThat(e)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(errorMessage);
    	}
    }
}
