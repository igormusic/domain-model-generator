package com.transactrules.model.datatypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonTypeName("Object")
public class ObjectDataType extends DataType {
    private String objectType;

    public ObjectDataType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String getTypeName() {
        return objectType;
    }
}
