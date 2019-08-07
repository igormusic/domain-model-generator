package com.transactrules.generator;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import com.transactrules.model.AggregateRoot;

import java.io.*;

import static com.transactrules.utilities.Utility.getResourceFileAsString;

public class CodeGenerator {
    public String generateAggregateRoot(AggregateRoot aggregateRoot){
        StringWriter writer = new StringWriter();

        final File templateDir = new File("src/main/resources/templates");
        Mustache.Compiler compiler = Mustache.compiler().withLoader(new Mustache.TemplateLoader() {
            public Reader getTemplate (String name) throws FileNotFoundException {
                return new FileReader(new File(templateDir, name));
            }
        });

        String templateString = getResourceFileAsString("templates//aggregateRoot.mustache");
        Template template= compiler.compile(templateString);

        String code = template.execute(aggregateRoot);

        return code;
    }
}
