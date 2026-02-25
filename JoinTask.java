package com.accenture.demo.tasks;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.HashMap;
import java.util.Map;

@PreLoad(route = "v1.join.task", instances = 5)
public class JoinTask implements TypedLambdaFunction<Map<String, Object>, Map<String, String>> {

    @Override
    public Map<String, String> handleEvent(Map<String, String> headers,
                                           Map<String, Object> input,
                                           int instance) {

        String first = headers.get("one");
        String second = headers.get("two");

        Map<String, String> result = new HashMap<>();

        if (first != null) {
            String[] parts = first.split(" and ");
            result.put(parts[1], parts[0]);
        }

        if (second != null) {
            String[] parts = second.split(" and ");
            result.put(parts[1], parts[0]);
        }

        return result;
    }
}