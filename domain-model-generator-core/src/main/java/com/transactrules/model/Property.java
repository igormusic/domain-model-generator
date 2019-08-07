package com.transactrules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transactrules.model.datatypes.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Property {
    private String name;
    private DataType dataType;

    private Boolean isRequired;

    public Property(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public Property isRequired(Boolean isRequired) {
        this.isRequired = isRequired;
        return this;
    }

    @JsonIgnore
    public String getTypeName() {
        return dataType.getTypeName();
    }
}
