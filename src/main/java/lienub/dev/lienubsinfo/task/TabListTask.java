package lienub.dev.lienubsinfo.task;

import lienub.dev.lienubsinfo.LienubsInfo;
import lienub.dev.lienubsinfo.utils.InfoGetter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TabListTask extends BukkitRunnable {
    private final LienubsInfo plugin;

    public TabListTask(LienubsInfo plugin) {
        this.plugin = plugin;
    }

    public void run() {
        for (Player player : this.plugin.getServer().getOnlinePlayers()) {
            String currentName = player.getDisplayName();
            String ping = String.valueOf(InfoGetter.getPing(player));

            player.setPlayerListName(currentName + ChatColor.GRAY + " » " + ChatColor.YELLOW + ping + "ms");
        }
    }
}