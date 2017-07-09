Feature: Login to site


  Scenario Outline: Retweet click
    Given User opens login page
    When User clicks login
    And Login is "<Login>"
    And Password is "<Password>"
    And User submit form
    And Click on Retweet link in window
    And Click Retweet in window
    And Login to Tweeter if needed
    And Make 1000 retweets
    And Clicks logout
  Examples:
  |Login|Password|
  |LynxLynxy@gmail.com|Testpass1|
  |LynxLynxy@gmail.com|Testpass1|