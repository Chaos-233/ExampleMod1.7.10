package com.chaos233.tinkerslegacy;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaos233.tinkerslegacy.events.TraitEventHandler;
import com.chaos233.tinkerslegacy.traits.TraitMagnetic;
import com.chaos233.tinkerslegacy.traits.TraitRegistry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "tinkerslegacy", name = "Tinkers Legacy", version = Tags.VERSION, acceptedMinecraftVersions = "[1.7.10]")
public class TinkersLegacy {

    public static final String MODID = "tinkerslegacy";
    public static final String MODNAME = "Tinkers Legacy";
    public static final String VERSION = "0.0.1";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "com.chaos233.tinkerslegacy.ClientProxy",
        serverSide = "com.chaos233.tinkerslegacy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        // 读取配置文件
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        // 注册Trait
        TraitRegistry.register(new TraitMagnetic());

        // 注册Forge事件
        MinecraftForge.EVENT_BUS.register(new TraitEventHandler());
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
