package apichainning;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

    
public class chainning {

	public static int ID;
	
	@Test(priority=1)
	public void Post() {
	
	RestAssured.baseURI="https://petstore.swagger.io/v2";
	
	 Response res=given()
	.log().all()
	.header("accept","application/json")
	.header("Content-Type","application/json")
	.body(body.PostBody())
	
	.when()
	.post("/store/order")
	
	.then()
	.extract()
	.response();
	 String response=res.asPrettyString();
	 JsonPath js=new JsonPath(response);
	   
	 ID=js.getInt("id");
	}
	
	
	
	
	@Test(priority=2)
	public void Delete() {
	
	RestAssured.baseURI="https://petstore.swagger.io/v2";
	
	 Response res2=given()
	.header("accept","application/json")
	.header("Content-Type","application/json")
	
	.when()
	.delete("/store/order/"+ID+"")
	
	.then()
	.extract()
	.response();
	
	String response2=res2.asPrettyString();
	System.out.println(response2);
	}
}
