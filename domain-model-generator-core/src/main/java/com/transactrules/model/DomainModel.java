package com.transactrules.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DomainModel {
    private List<AggregateRoot> aggregateRoots = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();
    private List<EnumType> enums = new ArrayList<>();

    public AggregateRoot addAggregateRoot(String name){
        AggregateRoot aggregateRoot = new AggregateRoot(name);
        aggregateRoots.add(aggregateRoot);
        return aggregateRoot;
    }

    public Entity addEntity(String name){
        Entity entity = new Entity(name);
        entities.add(entity);
        return entity;
    }

    public EnumType addEnum(String name, String ... values){
        EnumType enumType = new EnumType(name, values);
        enums.add(enumType);
        return enumType;
    }
}
