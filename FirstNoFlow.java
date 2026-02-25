package com.accenture.demo.tasks;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.exception.AppException;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.Map;

@PreLoad(route = "v1.firstno.flow", instances = 5)
public class FirstNoFlow implements TypedLambdaFunction<Map<String, Object>, String> {

    @Override
    public String handleEvent(Map<String, String> headers,
                              Map<String, Object> input,
                              int instance) {

        String value = headers.get("first_no");
        if (value == null) {
            throw new AppException(400, "Missing first_no");
        }

        int number = Integer.parseInt(value);
        String type = (number % 2 == 0) ? "even" : "odd";

        return type + " and " + number;
    }
}