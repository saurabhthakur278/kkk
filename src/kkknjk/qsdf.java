package kkknjk;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class qsdf {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.useRelaxedHTTPSValidation();
		 
		 
		String res=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "")
		  .when().post("/maps/api/place/add/json")
		
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		
		System.out.println(res);
		
		JsonPath js=new JsonPath(res);
		String plceId=js.get("place_id");
		System.out.println(plceId);
		

		String add="70 Summer walk, USA";
		
//		
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+plceId+"\",\r\n"
				+ "\"address\":\""+add+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		
		
		
		String responseible=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", plceId)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		
//		JsonPath js1=new JsonPath(response);
		JsonPath js1=reusable.rawtoJson(responseible);
		String  addr1=js1.get("address");
	
		System.out.println("--------"+addr1);
		Assert.assertEquals(addr1,add );
		
	}
	
	

}
