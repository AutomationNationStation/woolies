Feature: Weather Api Call

  Scenario: Output Sydney Weather
    Given I make the below api calls to the weather map
      | City | sydney,au |
    Then I should see which days will be above 20 degrees and sunny