package com.example.demo.service;

import com.example.demo.pojo.Service1Payload;

public interface ApiService {

	String callApi(String apiName, Object payload);
}