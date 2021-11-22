package com.test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleDummyRestAPI {

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
	}

	/*
	 * @Test public void testAPIToFetchAllEmployees() { Response response = given()
	 * .when() .get("/employees") .then() .extract() .response();
	 * 
	 * assertEquals(200, response.statusCode()); assertEquals("success",
	 * response.jsonPath().getString("status")); assertEquals("Tiger Nixon",
	 * response.jsonPath().getString("data.employee_name[0]")); }
	 */
	
/*	
	  @Test public void testAPIToCreateNewEmployee() {
	  
	  String requestBody = "{\n" + "  "
	  		+ "\"name\": \"Shilpi\",\n" +
	        "  \"salary\": \"10000\",\n" + " "
	  		+ " \"age\": \"20\",\n}";
	  
	  Response response = given() .header("Content-type", "application/json")
	  .and() .body(requestBody) .when() .post("/create") .then()
	  .extract().response();
	  
	  assertEquals(200, response.statusCode()); 
	  assertEquals("success", response.jsonPath().getString("status"));
	  assertEquals("Successfully! Record has been added.", response.jsonPath().getString("message")); 
	  assertEquals("10000", response.jsonPath().getString("data.salary")); 
	  }
	  
	 
	// /employee/{id}  : Path parameter
  @Test 
  public void testAPIToFetchSingleEmployee() { 
	  Response response = given()
                          .when() 
                          .get("/employee/101") 
                          .then() 
                          .extract() 
                          .response();
  
  assertEquals(200, response.statusCode()); 
  assertEquals("success", response.jsonPath().getString("status"));
  assertEquals("Tiger Nixon", response.jsonPath().getString("employee_name"));
  assertEquals("320800", response.jsonPath().getString("employee_salary"));
  }
 
  

  // /update
  @Test 
  public void testAPIToUpdateEmployeeRecord() {
	  
	  String requestBody = "{\n" + "  "
	  		+ "\"name\": \"Shilpi\",\n" +
	        "  \"salary\": \"20000\",\n" + " "
	  		+ " \"age\": \"20\",\n}";
	  
	  Response response = given() 
			  .header("Content-type", "application/json")
			  .and() 
			  .body(requestBody) 
			  .when() 
			  .put("/update") 
			  .then()
	          .extract()
	          .response();
	  
	  assertEquals(200, response.statusCode()); 
	  assertEquals("success", response.jsonPath().getString("status"));
	  assertEquals("Successfully! Record has been Updated.", response.jsonPath().getString("message")); 
	  assertEquals("20000", response.jsonPath().getString("data.salary")); 
	  }
  
  */
	
	
  // https://samples.openweathermap.org/data/2.5/weather?q={city}&appid={appId}
	// anything after ? is called query string
	// parameters are called Query parameters
	// Query parameters are separated using & operator
  @Test
  public void queryParameter() {
		
	RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/"; 
	RequestSpecification request = RestAssured.given();
	
	Response response = request.queryParam("q", "London,UK") 
			                   .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
			                   .get("/weather");
	
	String jsonString = response.asString();
	System.out.println(response.getStatusCode()); 
	assertEquals(jsonString.contains("London"), true);
	
}
  
  	@Test 
	public void testAPIWithIncorrectInfoToCreateNewEmployee() {
	  
	  String requestBody = "{\n" + "  "
	  		+ "\"name\": \"Shilpi\",\n" +
	        "  \"salary\": \"10000\",\n" + " "
	  		+ " \"age\": \"20\",\n}";
	  
	  Response response = given() .
			  			  header("Content-type", "application/json")
			  			  .and() 
			  			  .body(requestBody) 
			  			  .when() 
			  			  .get("/create") .then()
			  			  .extract()
			  			  .response();
	  
	  assertEquals(404, response.statusCode()); 
	  assertEquals("Error Occured! Page Not found, contact rstapi2example@gmail.com", response.jsonPath().getString("message"));
  	} 
}




