package post;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class Store_Order {

	@Test()
	public void Post() {
	
	RestAssured.baseURI="https://petstore.swagger.io/v2";
	
	given()
	.log().all()
	.header("accept","application/json")
	.header("Content-Type","application/json")
	.body(Body.body())
	
	.when()
	.post("/store/order")
	
	.then()
	.log().all()
	.extract()
	.response();
	
	}
	
}
