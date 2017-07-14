Feature: Wiki check
  Background:
    Given User opens wiki
    And test

  Scenario: User search Lynx
    When User fill "Lynx" in search
    And User clicks search
    And User move to Iberian lynx
    And User change language

  Scenario Outline: User search more
    When User fill "<SearchParams>" in search
    And User clicks search
    Examples:
      |SearchParams|
      |Elephant|
      |Cat|
      |Rhino|
      |Puma|
      |Dog|
      |Butterfly|
      |Chitos|
      |Monkey|

