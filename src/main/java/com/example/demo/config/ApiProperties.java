package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

	private Map<String, String> urls;
	private Map<String, String> jsonPayloads;

	public Map<String, String> getUrls() {
		return urls;
	}

	public void setUrls(Map<String, String> urls) {
		this.urls = urls;
	}

	public Map<String, String> getJsonPayloads() {
		return jsonPayloads;
	}

	public void setJsonPayloads(Map<String, String> jsonPayloads) {
		this.jsonPayloads = jsonPayloads;
	}
}