package be.masqueou.punishmaster.manager.commands;

import be.masqueou.punishmaster.PunishMaster;
import be.masqueou.punishmaster.commands.PunishCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandRoot {

    private final PunishMaster punishMaster;
    private List<CommandManager> punishCommandList = new ArrayList<>();

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
