package com.example.demo.service;

import com.example.demo.util.HealthCheckUtil;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class Service2HealthCondition implements ExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		if (HealthCheckUtil.isService2Up()) {
			return ConditionEvaluationResult.enabled("Service2 is up");
		} else {
			return ConditionEvaluationResult.disabled("Service2 is down");
		}
	}
}