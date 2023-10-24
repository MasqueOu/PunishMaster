package be.masqueou.punishmaster.spigot;

import be.masqueou.punishmaster.spigot.database.mysql.manager.MySQLManager;
import be.masqueou.punishmaster.spigot.manager.commands.CommandRoot;
import be.masqueou.punishmaster.spigot.manager.listeners.ListenersManager;
import be.masqueou.punishmaster.spigot.utils.config.Settings;
import be.masqueou.punishmaster.spigot.utils.ip.AddressUtils;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.MultiLineChart;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PunishMaster extends JavaPlugin {

    private Settings settings;
    private MySQLManager mySQLManager;
    private AddressUtils adressUtils;

    @Override
    public void onEnable() {
        // In first : Load Config - 50% Done
        this.settings = new Settings();
        this.adressUtils = new AddressUtils(this);
        // Enable Database connection - 50% done
        this.setupDatabase();
        new ListenersManager(this);
        this.checkUpdate();
        new CommandRoot(this);
        this.setupBStats();
        super.onEnable();
    }

    private void setupBStats() {
        if(getSettings().enable_bstats)
            new Metrics(this, 20109).addCustomChart(new MultiLineChart("players_and_servers", () -> {
                Map<String, Integer> valueMap = new HashMap<>();
                valueMap.put("servers", 1);
                valueMap.put("players", Bukkit.getOnlinePlayers().size());
                return valueMap;
            }));
    }

    private void checkUpdate() {
        if (getSettings().main_check_update) {
            // TODO
        }
    }

    private void setupDatabase() {
        if (getSettings().database_mysql_use && getSettings().database_sqlite_use) {
            System.out.println("Configuration Error: SQLite & MySQL are enabled. Only one database can be activated.");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
        } else if (getSettings().database_mysql_use) {
            mySQLManager = new MySQLManager(this);
        } else if (getSettings().database_sqlite_use) {
            // mySQLManager = new MySQLManager(this);
        } else {
            System.out.println("Configuration Error: SQLite & MySQL are both disabled.");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public Settings getSettings() {
        return settings;
    }

    public MySQLManager getMySQLManager() {
        return mySQLManager;
    }
}
