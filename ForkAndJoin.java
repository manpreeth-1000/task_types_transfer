package com.accenture.demo.tasks;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.Map;

@PreLoad(route = "v1.forkandjoin", instances = 5)
public class ForkAndJoin implements TypedLambdaFunction<Map<String, Object>, Void> {

    @Override
    public Void handleEvent(Map<String, String> headers,
                            Map<String, Object> input,
                            int instance) {

        System.out.println("fork and join has started");
        return null; // ignored in fork
    }
}