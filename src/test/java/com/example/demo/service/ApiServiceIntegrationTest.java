package com.example.demo.service;

import com.example.demo.pojo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApiServiceIntegrationTest {

	@Autowired
	private ApiService apiService;

	@Test
	public void testCallApiWithPayload() {
		String apiName = "service1";

		// Create the payload
		Payload payload = new Payload();
		payload.setId("0001");
		payload.setType("donut");
		payload.setName("Cake");
		payload.setPpu(0.55);

		Batters batters = new Batters();
		batters.setBatter(Arrays.asList(new Batter("1001", "Regular"), new Batter("1002", "Chocolate"), new Batter("1003", "Blueberry"), new Batter("1004", "Devil's Food")));
		payload.setBatters(batters);

		payload.setTopping(Arrays.asList(new Topping("5001", "None"), new Topping("5002", "Glazed"), new Topping("5005", "Sugar"), new Topping("5007", "Powdered Sugar"), new Topping("5006", "Chocolate with Sprinkles"), new Topping("5003", "Chocolate"), new Topping("5004", "Maple")));

		// Call the API with the Payload
		String response = apiService.callApi(apiName, payload);

		// Assert the response
		assertNotNull(response);

	}

//		@Test
//		public void testCallService2() {
//			String apiName = "service2";
//
//			// Assume Service2Payload is another payload POJO
//			Service2Payload payload = new Service2Payload();
//			payload.setKeyA("valueA");
//			payload.setKeyB("valueB");
//
//			String response = apiService.callApi(apiName, payload);
//
//			assertNotNull(response);
//			// Optionally, assert more details about the response if needed
//			System.out.println(apiName + " Response: " + response);
//		}

	// Repeat similar tests for other APIs...
}