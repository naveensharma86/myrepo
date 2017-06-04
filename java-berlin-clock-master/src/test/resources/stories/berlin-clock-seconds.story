Story: The Berlin Clock Seconds

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: TopMinutes00
When the second is 00
Then the seconds row should look like
Y

Scenario: TopMinutes01
When the second is 01
Then the seconds row should look like
O

Scenario: TopMinutes09
When the second is 09
Then the seconds row should look like
O

Scenario: TopMinutes16
When the second is 16
Then the seconds row should look like
Y

Scenario: TopMinutes59
When the second is 59
Then the seconds row should look like
O