package be.masqueou.punishmaster.spigot.manager.listeners;

import be.masqueou.punishmaster.spigot.PunishMaster;
import be.masqueou.punishmaster.spigot.listeners.AsyncPlayerChatListener;
import be.masqueou.punishmaster.spigot.listeners.PlayerPreLoginListener;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    private final PunishMaster punishMaster;

    public ListenersManager(PunishMaster punishMaster) {
        this.punishMaster = punishMaster;
        registerEvents();
    }

    private void registerEvents() {
        PluginManager pluginManager = this.punishMaster.getServer().getPluginManager();
        pluginManager.registerEvents(new AsyncPlayerChatListener(this.punishMaster), this.punishMaster);
        pluginManager.registerEvents(new PlayerPreLoginListener(this.punishMaster), this.punishMaster);
    }
}
