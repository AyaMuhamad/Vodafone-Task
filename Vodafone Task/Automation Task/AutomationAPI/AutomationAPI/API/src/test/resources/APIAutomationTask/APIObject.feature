Feature: Object Management
  @testcase1
  Scenario: Add an object with valid data
    Given User add an object with required data
    Then The object will be added successfully

   @testcase2
  Scenario: Delete the object using it's ID
    Given User has have an existing object added before
    When User delete the object using its ID
    Then The object will be deleted successfully