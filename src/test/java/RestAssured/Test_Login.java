package RestAssured;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Test_Login {

    private int port = 8080;

    @BeforeClass
    public void setUp() {
        RestAssured.port = this.port;
    }

    @Test
    public void Test_NavigateToAnywhere_RequiresAuthorisation() {
        when().
                get("/anywhere").
                then().
                statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void Test_GetJsonWebToken_WithProperCredentials() {
        JSONObject jsonObj = new JSONObject()
                .put("emailAddress", "reinoudvanzoelen@gmail.com")
                .put("password", "mijnwachtwoord");

        given()
                //.port(31111) // port number
                .contentType("application/json")  //another way to specify content type
                .body(jsonObj.toString())   // use jsonObj toString method
                .when()
                .post("/token/authenticate")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                // TODO: Verify the body of a json token
                .body("message", equalTo("{\"resultMessage\":\"Message accepted\"}"));

    }

    @Test
    public void Test_GetJsonWebToken_InvalidCredentials() {
        JSONObject jsonObj = new JSONObject()
                .put("emailAddress", "reinoudvanzoelen@gmail.com")
                .put("password", "ditisnietmijnwachtwoord");

        given()
                //.port(31111) // port number
                .contentType("application/json")  //another way to specify content type
                .body(jsonObj.toString())   // use jsonObj toString method
                .when()
                .post("/token/authenticate")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }

    @Test
    public void Test_GetJsonWebToken_NonExistantAccount(){
        JSONObject jsonObj = new JSONObject()
                .put("emailAddress","pietjepuck@bestaatniet.com")
                .put("password","mijnwachtwoord");

        given()
                //.port(31111) // port number
                .contentType("application/json")  //another way to specify content type
                .body(jsonObj.toString())   // use jsonObj toString method
                .when()
                .post("/token/authenticate")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }


}
