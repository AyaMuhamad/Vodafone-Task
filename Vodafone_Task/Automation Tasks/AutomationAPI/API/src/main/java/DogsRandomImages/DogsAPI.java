package DogsRandomImages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class DogsAPI {

    private Response response;


    public void sendRequest(String url) {
        try {
            response = given()
                    .when()
                    .get(url);
        } catch (Exception e) {
            System.err.println("Error sending request to URL: " + url);
            response = null;
        }
    }


    public void checkStatusCode(int expectedStatusCode) {
        assertNotNull(response, "Response is null");
        assertEquals(response.statusCode(), expectedStatusCode, "Unexpected status code");
    }


    public void checkContentType(String expectedContentType) {
        assertNotNull(response, "Response is null");
        assertEquals(response.getContentType(), expectedContentType, "Unexpected content type");
    }


    public void checkImageUrlIsValid() {
        String imageUrl = getImageUrlFromResponse();
        assertNotNull(imageUrl, "Image URL is null or missing in response");

        boolean isValid = imageUrl.matches(".*\\.(jpg|jpeg|png)$");
        assertTrue(isValid, "Image URL format is invalid: " + imageUrl);
    }


    public void checkImageUrlIsInvalid() {
        String imageUrl = getImageUrlFromResponse();

        if (imageUrl != null) {

            boolean isValid = imageUrl.matches(".*\\.(jpg|jpeg|png)$");
            assertFalse(isValid, "Expected an invalid image URL but got a valid one: " + imageUrl);

        }
    }

    public String getImageUrlFromResponse() {
        try {
            assertNotNull(response, "Response is null");
            return response.jsonPath().getString("message");
        } catch (Exception e) {
            System.err.println("Error extracting image URL: " + e.getMessage());
            return null;
        }
    }
}
