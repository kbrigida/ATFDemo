Feature: Login to site
  Background:
    Given User opens login page

    Scenario: User logs to system
      When User clicks login
      And Login is "<Login>"
      And Password is "<Password>"
      And User submit form
    Examples:
    |Login|Password|
    |LynxLynxy@gmail.com|Testpass1|
    |customerTabOpen|Customer Information|
