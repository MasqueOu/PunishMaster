package be.masqueou.punishmaster.spigot;

import be.masqueou.punishmaster.spigot.manager.commands.CommandRoot;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.MultiLineChart;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PunishMaster extends JavaPlugin {

    @Override
    public void onEnable() {
        new CommandRoot(this);

        setupBStats();
        super.onEnable();
    }

    private void setupBStats() {
        new Metrics(this, 20109).addCustomChart(new MultiLineChart("players_and_servers", () -> {
            Map<String, Integer> valueMap = new HashMap<>();
            valueMap.put("servers", 1);
            valueMap.put("players", Bukkit.getOnlinePlayers().size());
            return valueMap;
        }));
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
