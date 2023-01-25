package ru.cold.animatedtab;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnimatedTab extends JavaPlugin {

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            Bukkit.getLogger().warning("PAPI is required to work.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        TabManager tab = new TabManager();
        tab.addHeaderLine("&6TestServer"); // Specify the server name and the color of the label in ""
        tab.addHeaderLine("&61.12.2"); // Specify the server version and the color of the label in ""
        tab.addHeaderLine("&8%player_name%"); // Player Name
        tab.addHeaderLine("&fping: %player_ping%"); // player's ping
        tab.addHeaderLine("&ftps: %server_tps%"); // TPS Server
        tab.addHeaderLine("&6"); // Empty string

        tab.addFooterLine("&6"); // Empty string
        tab.addFooterLine("mc.server.net"); // IP servers

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            for(Player player : Bukkit.getOnlinePlayers()) {
                tab.update(player);
            }
        }, 0L, 20L);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
