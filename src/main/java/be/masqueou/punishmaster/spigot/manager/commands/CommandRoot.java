package be.masqueou.punishmaster.spigot.manager.commands;

import be.masqueou.punishmaster.spigot.PunishMaster;
import be.masqueou.punishmaster.spigot.commands.PunishCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandRoot {

    private final PunishMaster punishMaster;
    private final List<CommandManager> punishCommandList = new ArrayList<>();

    public CommandRoot(PunishMaster mainClazz) {
        this.punishMaster = mainClazz;

        Collections.addAll(punishCommandList,
                new PunishCommand()

        );
        this.registerCommands();
    }

    private void registerCommands() {
        for(CommandManager commandManager : this.punishCommandList) {
            commandManager.setExecutor(this.punishMaster);
        }
    }

}
