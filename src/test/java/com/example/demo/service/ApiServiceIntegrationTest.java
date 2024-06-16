package com.example.demo.service;

import com.example.demo.pojo.Service1Payload;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApiServiceIntegrationTest {

	@Autowired
	private ApiService apiService;

	@Test
	public void testCallService1() {
		String apiName = "service1";

		// Create a Service1Payload object
		Service1Payload payload = new Service1Payload();
		payload.setKey1("value1");
		payload.setKey2("value2");

		String response = apiService.callApi(apiName, payload);

		assertNotNull(response);
		// Optionally, assert more details about the response if needed
		System.out.println(apiName + " Response: " + response);
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