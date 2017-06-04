Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: WrongDititalHours
When the time is 24:00:00
Then the clock should throw error
input time is not correct

Scenario: WrongDititalMinutes
When the time is 23:60:00
Then the clock should throw error
input time is not correct

Scenario: WrongDititalSeconds
When the time is 23:23:60
Then the clock should throw error
input time is not correct