package com.example.demo.service;

import com.example.demo.config.ApiProperties;
import com.example.demo.pojo.Service1Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

	private final RestTemplate restTemplate;
	private final ApiProperties apiProperties;

	@Autowired
	public ApiServiceImpl(RestTemplate restTemplate, ApiProperties apiProperties) {
		this.restTemplate = restTemplate;
		this.apiProperties = apiProperties;
	}

	@Override
	public String callApi(String apiName, Object payload) {
		String apiUrl = apiProperties.getUrls().get(apiName);

		if (apiUrl == null) {
			throw new IllegalArgumentException("API URL not configured for: " + apiName);
		}

		return restTemplate.postForObject(apiUrl, payload, String.class);
	}
}