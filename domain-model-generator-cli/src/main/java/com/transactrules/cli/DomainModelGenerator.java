package com.transactrules.cli;

import com.transactrules.cli.cmd.Generate;
import com.transactrules.cli.cmd.Version;

import io.airlift.airline.Cli;
import io.airlift.airline.ParseArgumentsUnexpectedException;
import io.airlift.airline.ParseOptionMissingException;
import io.airlift.airline.ParseOptionMissingValueException;

import java.util.Locale;

public class DomainModelGenerator {

    public static void main(String[] args) {
        String version = Version.readVersionFromResources();

        Cli.CliBuilder<Runnable> builder =
                Cli.<Runnable>builder("domain-model-generator-cli")
                        .withDescription(
                                String.format(
                                        Locale.ROOT,
                                        "Domain Model generator CLI (version %s).",
                                        version))
                        .withDefaultCommand(Generate.class)
                        .withCommands(
                                Generate.class,
                                Version.class
                        );

        try {
            builder.build().parse(args).run();

            // If CLI is run without a command, consider this an error. This exists after initial parse/run
            // so we can present the configured "default command".
            // We can check against empty args because unrecognized arguments/commands result in an exception.
            // This is useful to exit with status 1, for example, so that misconfigured scripts fail fast.
            // We don't want the default command to exit internally with status 1 because when the default command is something like "list",
            // it would prevent scripting using the command directly. Example:
            //     java -jar cli.jar list --short | tr ',' '\n' | xargs -I{} echo "Doing something with {}"
            if (args.length == 0) {
                System.exit(1);
            }
        } catch (ParseArgumentsUnexpectedException e) {
            System.err.printf(Locale.ROOT,"[error] %s%n%nSee 'openapi-generator help' for usage.%n", e.getMessage());
            System.exit(1);
        } catch (ParseOptionMissingException | ParseOptionMissingValueException e) {
            System.err.printf(Locale.ROOT,"[error] %s%n", e.getMessage());
            System.exit(1);
        }
    }
}
