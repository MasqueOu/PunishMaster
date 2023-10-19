package be.masqueou.punishmaster.manager.commands;

import be.masqueou.punishmaster.PunishMaster;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class CommandManager implements CommandExecutor, TabExecutor {
    protected PunishMaster punishMaster;
    private String commandName;
    protected CommandSender sender;

    public CommandManager(String commandName) {
        this.commandName = commandName;
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String msg, @NotNull String[] args) {
        this.sender = commandSender;
        if (!command.getName().equalsIgnoreCase(this.commandName)) return false;
        if (this.sender instanceof Player) {
            execute((Player) this.sender, (args == null ? new String[]{""} : args));
        } else {
            execute(this.sender, (args == null ? new String[]{""} : args));
        }
        return true;
    }

    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return tabExecutor(commandSender, strings);
    }

    public abstract void execute(Object sender, String[] args);
    public abstract List<String> tabExecutor(Object sender, String[] args);

    public void setExecutor(PunishMaster punishMaster) {
        this.punishMaster = punishMaster;
        punishMaster.getCommand(this.commandName).setExecutor(this);
        punishMaster.getCommand(this.commandName).setTabCompleter(this);
    }
}

