package be.masqueou.punishmaster.spigot.commands;

import be.masqueou.punishmaster.spigot.manager.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PunishCommand extends CommandManager {

    public PunishCommand() {
        super(new String[]{"punishmaster", "pm", "punish"});
    }

    @Override
    public void execute(Player player, String[] args) {
        /*
        base_command + noarg & help -> send help
        base_command + player_name -> open GUI
        base_command + ban + player_name + duration + reason -> ban player
        base_command + ban-ip + player_name/player_ip + duration + reason -> ban player_ip
        base_command + unban + player_name -> unban player
        base_command + unban-ip + player_name/player_ip -> unban player_ip
        base_command + mute + player_name + duration + reason -> mute player
        base_command + unmute + player_name -> unmute player
        base_command + kick + player_name + reason -> kick player
        base_command + history + player_name + (opt) listed_sanctions -> view player punishment history
        base_command + staffhistory + mod_name -> view staff punishment history
        base_command + rollback + mod_name + duration -> rollback every sanction executed by a specific staff member in a specific duration.
        base_command + lockdown + lockdown_value + duration -> blocks all connection requests received by the server.
         */
    }

    @Override
    public List<String> tabExecutor(Player player, String[] args) {
        List<String> completes = new ArrayList<>();
        assert args != null;
        if(args.length == 1){
            Collections.addAll(completes,
                    "help",
                    "ban",
                    "ban-ip",
                    "unban",
                    "unban-ip",
                    "mute",
                    "mute-ip",
                    "unmute",
                    "unmute-ip",
                    "kick",
                    "kick-ip",
                    "history",
                    "staffhistory",
                    "rollback",
                    "lockdown",
                    "staffchat");
            //TODO : Need to be replaced in the future by a condition (check if Proxy or Redis is used, etc..)
            Bukkit.getOnlinePlayers().forEach(onlinePlayer -> completes.add(onlinePlayer.getDisplayName()));
        }
        return completes;
    }
}
