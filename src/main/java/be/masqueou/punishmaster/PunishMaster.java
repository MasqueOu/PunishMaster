package be.masqueou.punishmaster;

import be.masqueou.punishmaster.manager.commands.CommandRoot;
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
