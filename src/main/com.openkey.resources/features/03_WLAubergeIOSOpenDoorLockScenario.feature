@DoorLockWLAubergeiOSApp
Feature: Open Door Lock using issued mobile key in Auberge Mobile App in iOS Device

  Scenario: Open Door Lock using Auberge Mobile App in iOS Device
  As a guest I should be able to open door lock using issued mobile key in Auberge mobile app when I login to Auberge app in iOS Device
    When Guest clicks on Key Icon on My Key Screen
    Then Access Granted check mark should be displayed

  Scenario: Open Door Lock multiple times using OpenKey Guest Mobile App in iOS Device
  As a guest I am opening the door multiple times at regular interval
    When I clicks the main key for given number of times
    Then It should open the lock successfully each time