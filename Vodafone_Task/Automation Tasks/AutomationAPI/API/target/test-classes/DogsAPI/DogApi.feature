Feature: Dog API Image Endpoint
  This feature tests the Dog API's behavior when fetching random images with valid and invalid endpoints.

  @testcase1
  Scenario Outline: Verify that the Dog API returns a random dog image successfully
    Given I send a GET request to the endpoint "<endpoint>"
    Then the response status code should be <statusCode>
    And the response content type should be "<contentType>"
    And the response should contain a valid image URL

    Examples:
      | endpoint                                | statusCode | contentType      |
      | https://dog.ceo/api/breeds/image/random | 200        | application/json |

  @testcase2
  Scenario Outline: Verify API fails to return image URL for an invalid path
    Given I send a GET request to the endpoint "<endpoint>"
    Then the response status code should be <statusCode>
    And the response shouldn't contain a valid image URL

    Examples:
      | endpoint                                 | statusCode |
      | https://dog.ceo/api/breeds/image/invalid | 404        |
