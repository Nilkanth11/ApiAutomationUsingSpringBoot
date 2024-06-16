package com.example.demo.service;

import com.example.demo.config.ApiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class ApiServiceImpl implements ApiService {

	private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

	private final RestTemplate restTemplate;
	private final ApiProperties apiProperties;
	private final Environment env;

	@Autowired
	public ApiServiceImpl(RestTemplate restTemplate, ApiProperties apiProperties, Environment env) {
		this.restTemplate = restTemplate;
		this.apiProperties = apiProperties;
		this.env = env;
	}

	@Override
	public <T> String callApi(String apiName, T payload, String serviceName) {

		int invocationCount = getInvocationCount(apiName);

		String apiUrl = apiProperties.getUrls().get(apiName);
		HttpHeaders headers = new HttpHeaders();

		headers.set("Authorization", "Bearer " + generateToken());
		headers.set("Content-Type", "application/json");


		HttpEntity<T> request = new HttpEntity<>(payload, headers);

		String finalResponse = null;
		for (int i = 0; i < invocationCount; i++) {
			// Log the request details
			logger.info("Service Name: {}", serviceName);
			logger.info("Request URL: {}", apiUrl);
			logger.info("HTTP Method: POST");
			logger.info("Request Headers: {}", headers);
			logger.info("Request Body: {}", payload);

			ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);

			// Log the response details
			logger.info("Invocation Count: {}", (i + 1));
			logger.info("Response Status Code: {}", response.getStatusCode());
			logger.info("Response Body: {}", response.getBody());

			finalResponse = response.getBody();
		}

		return finalResponse;
	}

	private String generateToken() {
		String currentTime = String.valueOf(System.currentTimeMillis());
		return "mocked-token" + currentTime;
	}

	private int getInvocationCount(String serviceName) {
		String propertyKey = serviceName + ".invocation.count";
		return env.getProperty(propertyKey, Integer.class, 1); // Default to 1 if not found
	}
}