package com.example.demo.service;

import com.example.demo.config.ApiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {

	private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

	private final RestTemplate restTemplate;
	private final ApiProperties apiProperties;

	@Autowired
	public ApiServiceImpl(RestTemplate restTemplate, ApiProperties apiProperties) {
		this.restTemplate = restTemplate;
		this.apiProperties = apiProperties;
	}

	@Override
	public <T> String callApi(String apiName, T payload) {
		String apiUrl = apiProperties.getUrls().get(apiName);
		HttpHeaders headers = new HttpHeaders();

		headers.set("Authorization", "Bearer " + generateToken());
		headers.set("Content-Type", "application/json");


		HttpEntity<T> request = new HttpEntity<>(payload, headers);

		// Log the request details
		logger.info("Request URL: {}", apiUrl);
		logger.info("HTTP Method: POST");
		logger.info("Request Headers: {}", headers);
		logger.info("Request Body: {}", payload);

		ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);

		if (apiUrl == null) {
			throw new IllegalArgumentException("API URL not configured for: " + apiName);
		}

		// Log the response details
		logger.info("Response Status Code: {}", response.getStatusCode());
		logger.info("Response Body: {}", response.getBody());

		return response.getBody();
	}

	private String generateToken() {
		return "mocked-token";
	}
}