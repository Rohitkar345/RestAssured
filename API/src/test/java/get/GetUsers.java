package get;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetUsers {

	
	@Test()
	public void Get() {
	
	RestAssured.baseURI="https://reqres.in/api";
	
    Response res=given()
	
	.when()
	.get("/users?page=2")
	
	.then()
	.extract()
	.response();
    
    System.out.println(res.getStatusCode());
    System.out.println(res.time());
    String response=res.asPrettyString();
    System.out.println(response);
    JsonPath js=res.jsonPath();
    int size=js.getInt("data.size()");
    for(int i=0; i<size; i++) {
    int ID=js.getInt("data["+i+"].id");  	
    String name=js.getString("data["+i+"].first_name");
    System.out.println(ID+"-"+name);
    }
	}
}
