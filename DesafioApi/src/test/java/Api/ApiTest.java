package Api;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ApiTest {
	
	private String idfilme = "tt1285016";
	private String apikey = "52ec71bf";
	private String endpoint = "http://www.omdbapi.com/?i={Filme_ID}&apikey={ApiKey}";
	@Before
	public void setup() {
		
	}
	@Test
	public void Desafio_1() {
		Response response = given()
				.pathParam("Filme_ID", idfilme)
				.pathParam("ApiKey", apikey)
				.get(endpoint);
		
		JsonPath jsonResponse = response.jsonPath();
		assertEquals("The Social Network", jsonResponse.get("Title"));
		assertEquals("2010", jsonResponse.get("Year"));
		assertEquals("English, French", jsonResponse.get("Language"));
		
	}
	@Test
	public void Desafio_2() {
		String Erro = "{\"Response\":\"False\",\"Error\":\"Incorrect IMDb ID.\"}";
		
		Response response = given()
				.pathParam("Filme_ID", "1234")
				.pathParam("ApiKey", apikey)
				.get(endpoint);
		
		assertEquals(Erro, response.asString());
		
	}
	@After
	public void teardown() {
		
	}

}
