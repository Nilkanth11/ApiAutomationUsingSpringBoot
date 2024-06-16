package com.example.demo.service;

public interface ApiService {

	<T> String callApi(String apiName, T payload);
}