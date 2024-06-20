package lienub.dev.lienubsinfo.listeners;

import lienub.dev.lienubsinfo.LienubsInfo;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener(@NotNull LienubsInfo plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent event) {
        joinMessage(event);
    }

    private void joinMessage(@NotNull PlayerJoinEvent event) {
        String joinMessage = ChatColor.GREEN + ChatColor.BOLD.toString() + "» "
                + ChatColor.RESET + event.getPlayer().getName();

        event.setJoinMessage(joinMessage);

    }
}
