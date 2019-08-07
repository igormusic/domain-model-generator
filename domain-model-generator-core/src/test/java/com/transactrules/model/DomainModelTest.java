package com.transactrules.model;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactrules.configuration.ObjectMapperConfiguration;
import com.transactrules.model.datatypes.EnumDataType;
import com.transactrules.model.datatypes.ObjectDataType;
import com.transactrules.model.datatypes.ValueDataType;
import org.junit.Test;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class DomainModelTest {

    private ObjectMapper mapper = ObjectMapperConfiguration.getYamlObjectMapper();

    @Test
    public void successSerializeAndDeserialize() throws IOException {
        DomainModel model = getDomainModel();

        String yamlString = mapper.writeValueAsString(model);

        assertThat(yamlString, containsString("type: \"ValueType\""));

        DomainModel model2 =  mapper.readValue(yamlString,new TypeReference<DomainModel>(){});

        assertThat(model2.getAggregateRoots().size(), is(1));
        assertThat(model2.getAggregateRoots().get(0).getProperties().size(), is(6));
        assertThat(model2.getEnums().size(), is(2));
    }

    public static DomainModel getDomainModel() {
        DomainModel model = new DomainModel();

        AggregateRoot facility = model.addAggregateRoot("Facility");

        EnumType facilityType =  model.addEnum("FacilityType","TERM", "OPERATING_LINE", "CREDIT_CARD");
        EnumType facilityStatus =  model.addEnum("FacilityStatus","APPROVED", "PENDING");

        facility.addEnumProperty("facilityType", "FacilityType");
        facility.addEnumProperty("status", "FacilityStatus");
        facility.addValueProperty("approvedAmount", ValueType.NUMBER);
        facility.addValueProperty("proposedAmount", ValueType.NUMBER);
        return model;
    }
}