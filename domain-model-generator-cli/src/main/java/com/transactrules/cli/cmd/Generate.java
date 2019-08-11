package com.transactrules.cli.cmd;

import io.airlift.airline.Command;
import io.airlift.airline.Option;
import com.transactrules.CodegenConstants;

@Command(name = "generate", description = "Generate domain model code")
public class Generate implements Runnable {

    @Option(name = {"-i", "--input-spec"}, title = "spec file", required = true,
            description = "location of the domain model spec, as URL or file (required)")
    private String spec;

    @Option(name = {"-o", "--output"}, title = "output directory",
            description = "where to write the generated files (current dir by default)")
    private String output = "";

    @Option(name = {"--api-package"}, title = "api package",
            description = CodegenConstants.API_PACKAGE_DESC)
    private String apiPackage;

    @Option(name = {"--model-package"}, title = "model package",
            description = CodegenConstants.MODEL_PACKAGE_DESC)
    private String modelPackage;

    @Override
    public void run() {
        System.out.println(spec);

    }
}