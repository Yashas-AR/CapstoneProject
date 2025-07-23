package com.SDETCapstone.RestAssuredCapstone;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ExcelUtils;

public class RestAssuredTest {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/register";
	}
	
    @Test(dataProvider = "excelData1", dataProviderClass = ExcelUtils.class)
    public void reqResPositiveCase(String email, String password) {
    	JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", password);
        
        
    	Response response= given()
    			 .header("x-api-key","reqres-free-v1")
    			 .contentType(ContentType.JSON)
                 .body(requestBody.toString())
    			 .when()
    			 .post();
    	
    	Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().get("id") instanceof Integer, "ID is not an integer!");
        Assert.assertTrue(response.jsonPath().get("token") instanceof String, "Token is not a string!");
   
    }
    @Test(dataProvider = "excelData2", dataProviderClass = ExcelUtils.class)
    public void reqResNegativeCase(String email, String password) {
    	JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", password);
        
    	Response response= given()
    			 .header("x-api-key","reqres-free-v1")
    			 .contentType(ContentType.JSON)
                 .body(requestBody.toString())
    			 .when()
    			 .post();
    	
    	System.out.println(response.toString());
    	Assert.assertEquals(response.getStatusCode(), 400);
    	Assert.assertEquals(response.jsonPath().getString("error"), "Note: Only defined users succeed registration");
   
    }
}