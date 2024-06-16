package com.example.demo.service;

import com.example.demo.util.HealthCheckUtil;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class Service1HealthCondition implements ExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		if (HealthCheckUtil.isService1Up()) {
			return ConditionEvaluationResult.enabled("Service1 is up");
		} else {
			return ConditionEvaluationResult.disabled("Service1 is down");
		}
	}
}