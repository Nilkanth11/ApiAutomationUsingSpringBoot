package com.example.demo.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HealthCheckUtil {

	private static final String SERVICE1_HEALTH_URL = "https://service1.example.com/health";
	private static final String SERVICE2_HEALTH_URL = "https://service2.example.com/health";
	// Add more URLs as needed

	public static boolean isService1Up() {
		return checkHealth(SERVICE1_HEALTH_URL);
	}

	public static boolean isService2Up() {
		return checkHealth(SERVICE2_HEALTH_URL);
	}

	// Generic method to check health
	private static boolean checkHealth(String url) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			return response.getStatusCode().is2xxSuccessful() && response.getBody().contains("UP");
		} catch (Exception e) {
			return false;
		}
	}
}
