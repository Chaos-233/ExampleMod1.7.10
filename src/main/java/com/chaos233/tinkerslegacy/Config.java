package com.chaos233.tinkerslegacy;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean magneticTraitEnabled = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        magneticTraitEnabled = configuration.getBoolean(
            "magneticTraitEnabled",
            Configuration.CATEGORY_GENERAL,
            magneticTraitEnabled,
            "Enable magnetic trait");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
