package com.accenture.demo.models;

import org.platformlambda.core.serializers.SimpleMapper;

import java.util.Map;

public class Number {

    public Integer value;

    public static Number create(int value) {
        var number = new Number();
        number.value = value;
        return number;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> toMap() {
        return SimpleMapper.getInstance().getMapper().readValue(this, Map.class);
    }
}