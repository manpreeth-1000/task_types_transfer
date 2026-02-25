package com.accenture.demo.models;

import org.platformlambda.core.serializers.SimpleMapper;

import java.util.Map;

public class String1 {

    public String value;

    public static String1 create(String value) {
        var string1 = new String1();
        string1.value = value;
        return string1;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> toMap() {
        return SimpleMapper.getInstance().getMapper().readValue(this, Map.class);
    }
}