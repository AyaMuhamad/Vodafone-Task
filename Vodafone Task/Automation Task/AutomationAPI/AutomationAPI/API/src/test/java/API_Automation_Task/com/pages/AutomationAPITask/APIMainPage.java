package API_Automation_Task.com.pages.AutomationAPITask;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class APIMainPage {

    public String objectId;
    public Response response;

    public void AddObject() {

        baseURI = "https://api.restful-api.dev";

        JSONObject data = new JSONObject();
        data.put("year", 2019);
        data.put("price", 1849.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Apple MacBook Pro 16");
        requestBody.put("data", data);

        response = RestAssured.
                given()
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
          .get("https://api.restful-api.dev/objects/" + objectId)
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
            AddObject();
        } else {

            given()
            .when()
              .get("https://api.restful-api.dev/objects/" + objectId)
            .then()
              .statusCode(200);
        }
    }

    public void deleteObject() {
        Response deleteResponse = RestAssured.delete("https://api.restful-api.dev/objects/" + objectId);

        deleteResponse.then().statusCode(200);

        deleteResponse.then().body("message", equalTo("Object with id = " + objectId + " has been deleted."));
    }


    public void verifyObjectDeleted() {

        given()
        .when()
          .get("https://api.restful-api.dev/objects/" + objectId)
        .then()
          .statusCode(404);
    }

    public static void validateSchema(@org.jetbrains.annotations.NotNull Response response, String schemaFilePath) {
        response
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath)));
    }

    public void validateProductResponseSchema() {
        String endpoint = "https://api.restful-api.dev/objects/";

        Response response = RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();

        validateSchema(response, "src/test/resources/schemas/products-schema.json");
    }


}


