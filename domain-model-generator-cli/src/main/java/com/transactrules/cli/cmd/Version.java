package com.transactrules.cli.cmd;

import io.airlift.airline.Command;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Command(name = "version", description = "Show version information")
@Log
public class Version implements Runnable {

    private static final String VERSION_PLACEHOLDER = "${project.version}";

    private static final String UNREADABLE_VERSION = "unreadable";
    private static final String UNSET_VERSION = "unset";
    private static final String UNKNOWN_VERSION = "unknown";

    public static String readVersionFromResources() {
        Properties versionProperties = new Properties();
        try (InputStream is = Version.class.getResourceAsStream("/version.properties")) {
            versionProperties.load(is);
        } catch (IOException ex) {
            log.severe ("Error loading version properties");
            return UNREADABLE_VERSION;
        }

        String version = versionProperties.getProperty("version", UNKNOWN_VERSION).trim();
        if (VERSION_PLACEHOLDER.equals(version)) {
            return UNSET_VERSION;
        } else {
            return version;
        }
    }

    @Override
    public void run() {
        String version = readVersionFromResources();
        System.out.println(version);
    }

}