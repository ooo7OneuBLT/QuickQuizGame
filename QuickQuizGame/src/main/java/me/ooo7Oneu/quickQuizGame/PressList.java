package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class PressList extends JavaPlugin {

    static List<String> pressList = new ArrayList<>();

    public static void addList(String team) {
        pressList.add(team);
        //Bukkit.getLogger().info(pressList.toString());
    }

    public static void removeList(String team) {
        pressList.remove(team);
        //Bukkit.getLogger().info(team + "をリストから削除しました。");
        //Bukkit.getLogger().info(pressList.toString());
        //Bukkit.getLogger().info( "startedGame: " +GUICommand.startedGame + "startedQuestion: " + GUICommand.startedQuestion);
        if (!pressList.isEmpty()) {
            if (pressList.getFirst().equals("red")) {
                SetBlockRedStone.redSetBlockRedStone();
            }
            if (pressList.getFirst().equals("blue")) {
                SetBlockRedStone.blueSetBlockRedStone();
            }
            if (pressList.getFirst().equals("yellow")) {
                SetBlockRedStone.yellowSetBlockRedStone();
            }
            if (pressList.getFirst().equals("green")) {
                SetBlockRedStone.greenSetBlockRedStone();
            }
        }
    }

    public static void removeAllList() {
        pressList.clear();
    }

}
