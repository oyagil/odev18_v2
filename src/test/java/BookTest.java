import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class BookTest {

    @Test
    public void testGetBooks() {
        // Get request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("https://demoqa.com/BookStore/v1/Books");

        // Status code assertion
        response.then().statusCode(200);

        //  assert etme
        String title = response.jsonPath().getString("books[0].title");
        Assert.assertEquals("Git Pocket Guide", title);

        String author = response.jsonPath().getString("books[0].author");
        Assert.assertEquals("Richard E. Silverman", author);


    }
}
