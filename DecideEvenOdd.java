package com.accenture.demo.tasks;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.exception.AppException;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.Map;

@PreLoad(route = "v1.decide.evenodd", instances = 10)
public class DecideEvenOdd implements TypedLambdaFunction<Map<String, Object>, Boolean> {

    private static final String RANDOM_NO = "random_no";

    @Override
    public Boolean handleEvent(Map<String, String> headers,
                               Map<String, Object> input,
                               int instance) {

        if (!headers.containsKey(RANDOM_NO)) {
            throw new AppException(400, "Missing random_no");
        }

        String value = headers.get(RANDOM_NO);

        try {
            int number = Integer.parseInt(value);

            // Return TRUE if even, FALSE if odd
            return number % 2 == 0;

        } catch (NumberFormatException e) {
            throw new AppException(400, "random_no must be a valid integer");
        }
    }
}