package com.transactrules.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
public class EnumType {
    private String name;
    private List<String> values;

    public EnumType(String name, String ... values) {
        this.name = name;
        this.values = new ArrayList<>(Arrays.asList(values));
    }
}
