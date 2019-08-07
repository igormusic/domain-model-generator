package com.transactrules.model.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EnumDataType.class, name = "Enum"),
        @JsonSubTypes.Type(value = ObjectDataType.class, name = "Object"),
        @JsonSubTypes.Type(value = ValueDataType.class, name = "ValueType"),
})
public abstract class DataType {
    @JsonIgnore
    public abstract String getTypeName();

}


