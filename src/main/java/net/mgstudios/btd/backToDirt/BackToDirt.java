package net.mgstudios.btd.backToDirt;

import net.mgstudios.btd.backToDirt.event.ShovelHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BackToDirt extends JavaPlugin {

    final Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        logger.info("===========================");
        logger.info("=== Back To Dirt Plugin ===");
        logger.info("===========================");
        logger.info("Back To Dirt: 1.2.0");
        logger.info("Back To Dirt Plugin has been initialized!");
        this.getServer().getPluginManager().registerEvents(new ShovelHandler(), this);
    }

    @Override
    public void onDisable() {
        logger.info("===========================");
        logger.info("=== Back To Dirt Plugin ===");
        logger.info("===========================");
        logger.info("Back To Dirt Plugin has been disabled!");
    }
}
