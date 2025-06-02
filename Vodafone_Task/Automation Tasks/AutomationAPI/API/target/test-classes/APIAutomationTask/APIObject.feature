Feature: Object Management through API
  This feature verifies the API behavior when creating and deleting objects.

  @testcase1
  Scenario: Add an object with valid data
    Given the user adds an object with required data
    Then the object should be added successfully

  @testcase2
  Scenario: Delete the object using its ID
    Given the user has an existing object already added
    When the user deletes the object using its ID
    Then the object should be deleted successfully
