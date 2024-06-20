package lienub.dev.lienubsinfo.utils;

import org.bukkit.entity.Player;

public class InfoGetter {
    private InfoGetter() {
        throw new IllegalStateException("Utility class");
    }

    public static Integer getPing(Player player) {
        return player.getPing();
    }
}
