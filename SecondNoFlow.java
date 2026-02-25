package com.accenture.demo.tasks;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.exception.AppException;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.Map;

@PreLoad(route = "v1.secondno.flow", instances = 5)
public class SecondNoFlow implements TypedLambdaFunction<Map<String, Object>, String> {

    @Override
    public String handleEvent(Map<String, String> headers,
                              Map<String, Object> input,
                              int instance) {

        String value = headers.get("second_no");
        if (value == null) {
            throw new AppException(400, "Missing second_no");
        }

        int number = Integer.parseInt(value);
        String type = (number % 2 == 0) ? "even" : "odd";

        return type + " and " + number;
    }
}