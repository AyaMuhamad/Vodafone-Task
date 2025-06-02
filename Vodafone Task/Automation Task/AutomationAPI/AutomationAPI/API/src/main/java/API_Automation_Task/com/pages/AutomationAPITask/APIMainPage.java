package API_Automation_Task.com.pages.AutomationAPITask;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class APIMainPage {

    private String objectId;
    protected Response response;


    public void addObject() {
        baseURI = "https://api.restful-api.dev";

        JSONObject data = new JSONObject();
        data.put("year", 2019);
        data.put("price", 1849.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Apple MacBook Pro 16");
        requestBody.put("data", data);

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("/objects")
                .then()
                .extract()
                .response();

        objectId = response.jsonPath().getString("id");
    }


    public void verifyObjectAdded() {
        given()
                .when()
                .get(baseURI + "/objects/" + objectId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("data.year", equalTo(2019))
                .body("data.price", equalTo(1849.99f))
                .body("data.'CPU model'", equalTo("Intel Core i9"))
                .body("data.'Hard disk size'", equalTo("1 TB"));
    }


    public void haveExistingObject() {
        if (objectId == null || objectId.isEmpty()) {
            addObject();
        } else {
            given()
                    .when()
                    .get(baseURI + "/objects/" + objectId)
                    .then()
                    .statusCode(200);
        }
    }


    public void deleteObject() {
        Response deleteResponse = given()
                .when()
                .delete(baseURI + "/objects/" + objectId);

        deleteResponse
                .then()
                .statusCode(200)
                .body("message", equalTo("Object with id = " + objectId + " has been deleted."));
    }


    public void verifyObjectDeleted() {
        given()
                .when()
                .get(baseURI + "/objects/" + objectId)
                .then()
                .statusCode(404);
    }


    public static void validateSchema(Response response, String schemaFilePath) {
        response
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath)));
    }


    public void validateProductResponseSchema() {
        String endpoint = baseURI + "/objects/";

        Response response = given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        validateSchema(response, "src/test/resources/schemas/products-schema.json");
    }
}
