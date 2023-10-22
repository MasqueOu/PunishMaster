package be.masqueou.punishmaster.spigot.listeners;

import be.masqueou.punishmaster.spigot.PunishMaster;
import org.bukkit.event.Listener;

public class AsyncPlayerChatListener implements Listener {

    private final PunishMaster punishMaster;
    public AsyncPlayerChatListener(PunishMaster punishMaster) {
        this.punishMaster = punishMaster;
    }
}
