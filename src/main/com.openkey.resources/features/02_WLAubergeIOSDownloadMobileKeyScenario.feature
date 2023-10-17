@DownloadMobileKeyWLAubergeiOSApp
Feature: Guest Downloading Mobile Key

  Scenario: Verify Active Key Screen when Guest has access to room on successfully downloading key

    When Guest click on Get My Key
    And Guest navigates to the Downloading Key Screen
    Then Guest should successfully able to download key
    And On the My Key Screen Hotel Name and Room Number should be displayed