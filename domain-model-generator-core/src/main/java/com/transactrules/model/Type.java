package com.transactrules.model;

import com.transactrules.model.datatypes.EnumDataType;
import com.transactrules.model.datatypes.ObjectDataType;
import com.transactrules.model.datatypes.ValueDataType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public abstract class Type {
    protected String name;

    protected List<Property> properties = new ArrayList<>();

    public Type(String name) {
        this.name = name;
    }


    public Property addValueProperty(String name, ValueType valueType){
        ValueDataType valueDataType = new ValueDataType(valueType);
        Property property = new Property(name, valueDataType);
        properties.add(property);

        return property;
    }

    public Property addObjectProperty(String name, String objectTypeName) {
        ObjectDataType objectDataType = new ObjectDataType(objectTypeName);

        Property property = new Property(name, objectDataType);
        properties.add(property);

        return property;
    }

    public Property addEnumProperty(String name, String enumTypeName) {

        Property property = new Property(name, new EnumDataType(enumTypeName));

        properties.add(property);

        return property;
    }


}
