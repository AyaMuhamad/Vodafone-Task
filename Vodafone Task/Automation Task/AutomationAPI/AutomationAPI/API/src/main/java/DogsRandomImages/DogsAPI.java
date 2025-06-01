package DogsRandomImages;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.testng.AssertJUnit.*;


public class DogsAPI {
    Response response;
    public void SendRequest(String url){
        response = given()
                .when()
                .get(url);
    }
    public void CheckTheStatusCode(int StatusCode){
        assertEquals( StatusCode, response.statusCode());
    }
    public void CheckTheContentType(String ContentType){
        assertEquals(ContentType, response.getContentType());
    }
    public void CheckTheResponseContainTheDogImage(){
        String imageUrl = response.jsonPath().getString("message");
        assertTrue("Image URL is invalid: " + imageUrl,
                imageUrl.endsWith(".jpg") || imageUrl.endsWith(".jpeg") || imageUrl.endsWith(".png"));
    }

    public void CheckTheInvalidResponse(){
            String imageUrl = getImageUrlFromResponse();
            assertFalse("Expected invalid image URL but got: " + imageUrl,
                    imageUrl != null && (imageUrl.endsWith(".jpg") || imageUrl.endsWith(".jpeg") || imageUrl.endsWith(".png")));

    }

    public String getImageUrlFromResponse() {
        try {
            return response.jsonPath().getString("message");
        } catch (Exception e) {
            return null;
        }
    }

}
