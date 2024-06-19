package lienub.dev.lienubsinfo.listeners;

import lienub.dev.lienubsinfo.LienubsInfo;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;

public class ChatListener implements Listener {

    /**
     * Our default constructor for {@link ChatListener}.
     */
    public ChatListener(@NotNull LienubsInfo plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onChat(@NotNull AsyncPlayerChatEvent event) {
        // cancel the event
        event.setCancelled(true);

        ChatColor color = event.getPlayer().isOp() ? ChatColor.RED : ChatColor.DARK_AQUA;
        // Resend the message with format and color
        event.getPlayer().spigot().sendMessage(
                new ComponentBuilder(event.getPlayer().getName()).color(color).bold(true)
                        .append(" » ").color(ChatColor.GRAY).bold(false)
                        .append(event.getMessage()).color(ChatColor.WHITE)
                        .create()
        );
    }
}
