Feature: Automate login screen for swaglabs application

  @test
  Scenario: Valid login
    Given the user is able to launch apk file in android device
    When user enters username and password
    And user clicks on login button
    Then user should be able to see homepage
