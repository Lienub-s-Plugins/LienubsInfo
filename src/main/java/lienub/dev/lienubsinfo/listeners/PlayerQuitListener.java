package lienub.dev.lienubsinfo.listeners;

import lienub.dev.lienubsinfo.LienubsInfo;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerQuitListener implements Listener {

    public PlayerQuitListener(@NotNull LienubsInfo plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(@NotNull PlayerQuitEvent event) {
        String quitMessage = ChatColor.RED + ChatColor.BOLD.toString() + "« "
                + ChatColor.RESET + event.getPlayer().getName();

        event.setQuitMessage(quitMessage);
    }
}
