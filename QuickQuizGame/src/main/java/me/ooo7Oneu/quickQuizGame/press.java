package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.scanner.ScannerImpl;

import java.util.Set;

public class press implements CommandExecutor {

    static Boolean isPressedRed = false;
    static Boolean isPressedBlue = false;
    static Boolean isPressedYellow = false;
    static Boolean isPressedGreen = false;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("press")) {
            if (strings.length == 0) {
                Bukkit.getLogger().info("実行したコマンドのサブコマンドが空欄です。");
                commandSender.sendMessage("§4実行したコマンドのサブコマンドが空欄です。");
                return false;
            } else if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("red")) {
                    if (GUICommand.startedGame) {
                        if (GUICommand.startedQuestion) {

                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.sendMessage("§c赤チームがボタンを押しました。");
                            }

                            PressList.addList("red");

                            if (PressList.pressList.getFirst().equals("red")) {
                                SetBlockRedStone.redSetBlockRedStone();
                                return true;
                            }
                        }
                    }
                }
                if (strings[0].equalsIgnoreCase("blue")) {
                    if (GUICommand.startedGame) {
                        if (GUICommand.startedQuestion) {

                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.sendMessage("§9青チームがボタンを押しました。");
                            }

                            PressList.addList("blue");

                            if (PressList.pressList.getFirst().equals("blue")) {
                                SetBlockRedStone.blueSetBlockRedStone();
                                return true;
                            }
                        }
                    }
                }
                if (strings[0].equalsIgnoreCase("yellow")) {
                    if (GUICommand.startedGame) {
                        if (GUICommand.startedQuestion) {

                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.sendMessage("§6黄色チームがボタンを押しました。");
                            }

                            PressList.addList("yellow");

                            if (PressList.pressList.getFirst().equals("yellow")) {
                                SetBlockRedStone.yellowSetBlockRedStone();
                                return true;
                            }
                        }
                    }
                }
                if (strings[0].equalsIgnoreCase("green")) {
                    if (GUICommand.startedGame) {
                        if (GUICommand.startedQuestion) {

                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.sendMessage("§2緑チームがボタンを押しました。");
                            }

                            PressList.addList("green");

                            if (PressList.pressList.getFirst().equals("green")) {
                                SetBlockRedStone.greenSetBlockRedStone();
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void resetPress() {
        if (PressList.pressList.isEmpty()) {
            GUICommand.startedQuestion = false;
        }
        if (isPressedRed) {
            Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.red.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.red.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.red.z") - 1);
            location.getBlock().setType(Material.AIR);
            isPressedRed = false;
            //whoPressed = "no";
        }
        if (isPressedBlue) {
            Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.z") - 1);
            location.getBlock().setType(Material.AIR);
            isPressedBlue = false;
            //whoPressed = "no";
        }
        if (isPressedYellow) {
            Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.z") - 1);
            location.getBlock().setType(Material.AIR);
            isPressedYellow = false;
            //whoPressed = "no";
        }
        if (isPressedGreen) {
            Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.green.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.green.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.green.z") - 1);
            location.getBlock().setType(Material.AIR);
            isPressedGreen = false;
            //whoPressed = "no";
        }
    }
}
