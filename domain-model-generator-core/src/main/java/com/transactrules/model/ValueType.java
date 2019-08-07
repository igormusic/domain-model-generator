package com.transactrules.model;

import java.util.HashMap;
import java.util.Map;

public enum ValueType {
    STRING("string"),
    DATE("date"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    IDENTITY("identity"),
    VERSION("version");

    private final String value;

    ValueType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    private static final Map<String, ValueType> lookup = new HashMap<>();

    static
    {
        for(ValueType item : ValueType.values())
        {
            lookup.put(item.value(), item);
        }
    }

    public static ValueType fromString(String value)
    {
        return lookup.get(value);
    }

}
