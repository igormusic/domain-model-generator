package com.transactrules.model.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.transactrules.model.ValueType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor()
@JsonTypeName("ValueType")
public class ValueDataType extends DataType {
    private ValueType valueType;

    public ValueDataType( ValueType valueType) {
        this.valueType = valueType;
    }

    @Override
    public String getTypeName() {
        String typeName;
        
        switch (valueType){
            case STRING:
            case IDENTITY:
                typeName = "String";
                break;
            case DATE:
                typeName = "LocalDate";
                break;
            case NUMBER:
            case VERSION:
                typeName = "Long";
                break;
            case BOOLEAN:
                typeName = "Boolean";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + valueType);
        }
        
        return typeName;
    }
}
