package be.masqueou.punishmaster.commands;

import be.masqueou.punishmaster.manager.commands.CommandManager;

import java.util.ArrayList;
import java.util.List;

public class PunishCommand extends CommandManager {

    public PunishCommand() {
        super("yolo");
    }

    @Override
    public void execute(Object sender, String[] args) {
        System.out.println("Testing...");
    }

    @Override
    public List<String> tabExecutor(Object sender, String[] args) {
        List<String> completes = new ArrayList<>();
        assert args != null;
        if(args.length == 1){
            completes.add("test1");
            completes.add("test2");
            completes.add("test3");
        } else if(args.length == 2){
            completes.add("test4");
            completes.add("test5");
            completes.add("test6");
        }
        return completes;
    }
}
