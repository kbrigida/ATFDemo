Feature: Console mode
  Background:
    Given TDK opened
    And TDK connected to server

  Scenario: Check Console UI
    When Click to Console view button
    And Check tile name "Console"
    And Check Help button exist
    And Check Option menu exist for Console
    And Check Console size
    And Console scroll bar exist IT CAN BE PROBLEM

  Scenario: Check console tile option menu
    When Click to Console view button
    And Click to Console options menu
    And Check options menu exist - Create new View, Add to View, Reset, Close exist

  Scenario: Check console view activation
    When Click to Console view button
    And Close Console view
    And Go to State View
    And Click to Console view button

  Scenario: UI Check Console Help screen
    When Click to Console view button
    And Click to Command list button
    And Check size
    And Check tile name "Help"
    And Check Search box and Close button exist
    And Check Close button exist
    And

