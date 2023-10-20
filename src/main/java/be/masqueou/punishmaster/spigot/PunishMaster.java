package be.masqueou.punishmaster.spigot;

import be.masqueou.punishmaster.spigot.manager.commands.CommandRoot;
import org.bukkit.plugin.java.JavaPlugin;

public class PunishMaster extends JavaPlugin {

    @Override
    public void onEnable() {
        new CommandRoot(this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
