Story: The Berlin Clock Hours

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: TopHour00
When the hour is 00
Then the top hours row should look like
OOOO

Scenario: TopHour03
When the hour is 03
Then the top hours row should look like
OOOO

Scenario: TopHour13
When the hour is 13
Then the top hours row should look like
RROO

Scenario: TopHour17
When the hour is 17
Then the top hours row should look like
RRRO

Scenario: TopHour23
When the hour is 23
Then the top hours row should look like
RRRR

Scenario: BottomHour00
When the hour is 00
Then the bottom hours row should look like
OOOO

Scenario: BottomHour01
When the hour is 01
Then the bottom hours row should look like
ROOO

Scenario: BottomHour03
When the hour is 03
Then the bottom hours row should look like
RRRO

Scenario: BottomHour04
When the hour is 04
Then the bottom hours row should look like
RRRR

Scenario: BottomHour05
When the hour is 05
Then the bottom hours row should look like
OOOO