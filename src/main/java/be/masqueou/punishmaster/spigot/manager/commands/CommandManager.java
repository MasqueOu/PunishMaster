package be.masqueou.punishmaster.spigot.manager.commands;

import be.masqueou.punishmaster.spigot.PunishMaster;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class CommandManager implements CommandExecutor, TabExecutor {
    protected PunishMaster punishMaster;
    private final String[] commandName;

    public CommandManager(String[] commandName) {
        this.commandName = commandName;
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String msg, @NotNull String[] args) {
        if (Arrays.stream(this.commandName).noneMatch(Predicate.isEqual(command.getName()))) return false;
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        execute(player, args);
        return true;
    }

    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return tabExecutor((Player) commandSender, strings);
    }

    public abstract void execute(Player player, String[] args);
    public abstract List<String> tabExecutor(Player player, String[] args);

    public void setExecutor(PunishMaster punishMaster) {
        this.punishMaster = punishMaster;
        for(String command_Name : this.commandName) {
            Objects.requireNonNull(punishMaster.getCommand(command_Name)).setExecutor(this);
            Objects.requireNonNull(punishMaster.getCommand(command_Name)).setTabCompleter(this);
        }
    }
}

