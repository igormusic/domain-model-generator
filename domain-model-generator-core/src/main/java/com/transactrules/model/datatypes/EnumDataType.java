package com.transactrules.model.datatypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonTypeName("Enum")
public class EnumDataType extends DataType {
    private String enumType;

    public EnumDataType(String enumType) {
        this.enumType = enumType;
    }

    @Override
    public String getTypeName() {
        return enumType;
    }
}
