import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class HomeWork {
    @Test
    public void endpointRespondOkWhenRequestCorrect()
    {
        given()
                .queryParam("api-key","Qetr40dvvIO8nHGx84QhHn1HJ6hLLbql").
                when()
                .get("https://api.nytimes.com/svc/movies/v2/reviews/picks.json").
                then().
                contentType(ContentType.JSON).
                statusCode(200)
        ;
    }
    @Test
    public void endpointRespondUnauthirizedWhenKeyIncorrect()
    {
        given()
                .queryParam("api-key","Qetr40dvvIO8nHGx84QhHHJ6hLLbql").
                when()
                .get("https://api.nytimes.com/svc/movies/v2/reviews/picks.json").
                then().
                contentType(ContentType.JSON).
                statusCode(401)
        ;
    }
    @Test
    public void endpointRespondBodyCorrect()
    {
        given()
                .queryParam("api-key","Qetr40dvvIO8nHGx84QhHn1HJ6hLLbql").
                when()
                .get("https://api.nytimes.com/svc/movies/v2/reviews/picks.json").
                then().
                contentType(ContentType.JSON).
                statusCode(200)
                .body("num_results",is(20))
                .body("results[0].byline",is("Lena Wilson"))
        ;
        Response response = given()
                .queryParam("api-key","Qetr40dvvIO8nHGx84QhHn1HJ6hLLbql").
                        when()
                .get("https://api.nytimes.com/svc/movies/v2/reviews/picks.json").
                        then().
                        contentType(ContentType.JSON).
                        statusCode(200).extract().response().prettyPeek();
        System.out.println(response);
        ;

    }
}
