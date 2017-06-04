Story: The Berlin Clock Minutes

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: TopMinutes00
When the minute is 00
Then the top minutes row should look like
OOOOOOOOOOO

Scenario: TopMinutes06
When the minute is 06
Then the top minutes row should look like
YOOOOOOOOOO

Scenario: TopMinutes14
When the minute is 14
Then the top minutes row should look like
YYOOOOOOOOO

Scenario: TopMinutes17
When the minute is 17
Then the top minutes row should look like
YYROOOOOOOO

Scenario: TopMinutes21
When the minute is 21
Then the top minutes row should look like
YYRYOOOOOOO

Scenario: TopMinutes26
When the minute is 26
Then the top minutes row should look like
YYRYYOOOOOO

Scenario: TopMinutes31
When the minute is 31
Then the top minutes row should look like
YYRYYROOOOO

Scenario: TopMinutes35
When the minute is 35
Then the top minutes row should look like
YYRYYRYOOOO

Scenario: TopMinutes36
When the minute is 36
Then the top minutes row should look like
YYRYYRYOOOO

Scenario: TopMinutes41
When the minute is 41
Then the top minutes row should look like
YYRYYRYYOOO

Scenario: TopMinutes46
When the minute is 46
Then the top minutes row should look like
YYRYYRYYROO

Scenario: TopMinutes51
When the minute is 51
Then the top minutes row should look like
YYRYYRYYRYO

Scenario: TopMinutes56
When the minute is 56
Then the top minutes row should look like
YYRYYRYYRYY

Scenario: TopMinutes59
When the minute is 59
Then the top minutes row should look like
YYRYYRYYRYY

Scenario: BottomMinute00
When the minute is 00
Then the bottom minutes row should look like
OOOO

Scenario: BottomMinute01
When the minute is 01
Then the bottom minutes row should look like
YOOO

Scenario: BottomMinute03
When the minute is 03
Then the bottom minutes row should look like
YYYO

Scenario: BottomMinute04
When the minute is 04
Then the bottom minutes row should look like
YYYY

Scenario: BottomMinute05
When the minute is 05
Then the bottom minutes row should look like
OOOO