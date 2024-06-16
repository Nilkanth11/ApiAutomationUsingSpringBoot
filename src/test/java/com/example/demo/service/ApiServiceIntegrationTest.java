package com.example.demo.service;

import com.example.demo.pojo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Execution(ExecutionMode.CONCURRENT)
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
		String response = apiService.callApi(apiName, payload,apiName);

		// Assert the response
		assertNotNull(response);

	}
	@Test
	public void testWithImage() {
		String apiName = "service2";

		// Create the payload
		Main main = new Main();
		main.setId("0001");
		main.setType("Laptop");
		main.setName("SecondService");

		Image image = new Image();
		image.setHeight(200);
		image.setWidth(200);
		image.setUrl("myURL");

		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setHeight(200);
		thumbnail.setUrl("myThumbnailUrl");
		thumbnail.setWidth(200);

		main.setImage(image);
		main.setThumbnail(thumbnail);

		String response = apiService.callApi(apiName,main,apiName);

		// Assert the response
		assertNotNull(response);

	}

}