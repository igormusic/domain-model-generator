package com.transactrules.generator;

import com.transactrules.model.DomainModel;
import com.transactrules.model.DomainModelTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CodeGeneratorTest {
    @Test
    public void successGenerateAggregateRoot() {
        DomainModel model = DomainModelTest.getDomainModel();

        CodeGenerator generator = new CodeGenerator();

        String code = generator.generateAggregateRoot(model.getAggregateRoots().get(0));

        assertThat(code.contains("private String id"), is(true));
    }

}