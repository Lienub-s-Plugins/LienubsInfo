package lienub.dev.lienubsinfo;

import lienub.dev.lienubsinfo.listeners.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LienubsInfo extends JavaPlugin {
    private static LienubsInfo instance;

    /**
     * Our default constructor for {@link LienubsInfo}.
     */
    public LienubsInfo() {
        super();
    }

    /**
     * Sets instance of the plugin.
     *
     * @param pluginInstance the plugin instance
     * @see #instance
     * @since 1.0
     */
    private static void setInstance(@Nullable LienubsInfo pluginInstance) {
        instance = pluginInstance;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @see #instance
     * @see JavaPlugin#getPlugin(Class)
     * @since 1.0
     */
    public static @NotNull LienubsInfo getInstance() {
        return getPlugin(LienubsInfo.class);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        setInstance(this);
        onPluginStart();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (instance == null) {
            return;
        }

        // Cancel all tasks
        Bukkit.getScheduler().cancelTasks(this);

        // Terminate instance
        setInstance(null);

    }

    public void onPluginStart() {
        long timestamp = System.nanoTime();
        Logger logger = getLogger();

        //Check Paper installation
        if (Bukkit.getVersion().contains("Paper")) {
            logger.info("Paper detected, continuing...");
        } else {
            logger.warning("Paper not detected, consider using it.");
        }

        //Check Java version
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.contains("1.8") || javaVersion.contains("1.9") || javaVersion.contains("1.10") || javaVersion.contains("1.11") || javaVersion.contains("1.12") || javaVersion.contains("1.13") || javaVersion.contains("1.14") || javaVersion.contains("1.15") || javaVersion.contains("1.16")) {
            logger.warning("Java version is outdated, please update to Java 17 or higher.");
        } else {
            logger.info("Java version is up to date.");
        }

        logger.log(Level.INFO, "Registering listeners...");
        registerListener();

        logger.log(Level.INFO, () -> "Plugin started in " + (System.nanoTime() - timestamp) + " nanoseconds.");

    }

    private void registerListener() {
        // Register listeners here
        new ChatListener(this);
    }
}
