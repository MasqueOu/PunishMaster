package be.masqueou.punishmaster.spigot.listeners;

import be.masqueou.punishmaster.spigot.PunishMaster;
import org.bukkit.event.Listener;

public class PlayerPreLoginListener implements Listener {

    private final PunishMaster punishMaster;
    public PlayerPreLoginListener(PunishMaster punishMaster) {
        this.punishMaster = punishMaster;
    }
}
