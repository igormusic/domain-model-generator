package com.transactrules.model;

import com.transactrules.model.datatypes.ValueDataType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AggregateRoot extends Type {
    public AggregateRoot(String name) {
        super(name);

        properties.add(new Property("id", new ValueDataType(ValueType.IDENTITY)).isRequired(true));
        properties.add(new Property("version", new ValueDataType(ValueType.VERSION)).isRequired(true));
    }
}
