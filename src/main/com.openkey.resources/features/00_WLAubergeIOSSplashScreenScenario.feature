@LaunchWLiOSApp
Feature: Launch Auberge Des Iles Mobile App in iOS Device

  Scenario: Launch Auberge Des Iles App in iOS Device
  As a guest I should be able to launch Auberge Des Iles iOS mobile app when I install Auberge Des Iles app in iOS Device

    Given Auberge Des Iles App is installed
    When Guest click on Auberge Des Iles app icon
    Then Auberge Des Iles App launched splash screen should be displayed
    And Permissions screen should be displayed

    When Guest click on Next button
    Then Auberge Des Iles would Like to Send You Notifications prompt should be displayed

    When Guest allows to Send Push Notifications
    Then Auberge Des Iles would Like to Use Bluetooth prompt should be displayed

    When Guest allows Bluetooth access
    Then Allow Auberge Des Iles to use your location prompt should be displayed

    When Guest selects option Allow While Using App
    Then Guest navigates to Find My Reservation Screen

