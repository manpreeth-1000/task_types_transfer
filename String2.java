package com.accenture.demo.models;

import org.platformlambda.core.serializers.SimpleMapper;

import java.util.Map;

public class String2 {

    public String value;

    public static String2 create(String value) {
        var string2 = new String2();
        string2.value = value;
        return string2;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> toMap() {
        return SimpleMapper.getInstance().getMapper().readValue(this, Map.class);
    }
}