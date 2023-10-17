@LoginToWLAubergeiOSApp
Feature: Login to Auberge Mobile App in iOS Device

  Scenario: Login to Auberge App in iOS Device
  As a guest I should be able to login to Auberge mobile app when I entered registered mobile number and verification code to Auberge app in iOS Device

    When Guest entered register mobile number
    And Guest click on Request Verification Code Button
    Then Verification Screen should be displayed

    When Read the Verification Code
    Then Downloading key screen should be displayed