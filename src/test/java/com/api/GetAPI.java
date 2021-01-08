package com.api;


import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPI {

	@Test
	void MyOrange() {

		Date date = new Date();
		System.out.println(date.toString());

		Response response =	RestAssured.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewLocations");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getContentType());
		System.out.println(response.getHeaders().asList());

		
		  int code = response.getStatusCode(); 
		  Assert.assertEquals(code, 200);
		  System.out.println("Condotion True");
		 
		


	}

}
