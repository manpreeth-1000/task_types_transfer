package com.accenture.demo.tasks;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.exception.AppException;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.Map;

@PreLoad(route = "v1.odd.flow.one", instances = 10)
public class OddFlowOne implements TypedLambdaFunction<Map<String, Object>, String> {

    private static final String NUMBER = "number";

    @Override
    public String handleEvent(Map<String, String> headers,
                              Map<String, Object> input,
                              int instance) {

        if (!headers.containsKey(NUMBER)) {
            throw new AppException(400, "Missing number header");
        }

        String value = headers.get(NUMBER);

        try {
            System.out.println(value);
            return "odd and one";

        } catch (NumberFormatException e) {
            throw new AppException(400, "Invalid number format");
        }
    }
}