package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.ServerOperator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SetRedStonePos implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.isOp()) {
            if (!GUICommand.startedGame) {
                if (commandSender instanceof Player player) {
                    if (command.getName().equalsIgnoreCase("setpos")) {
                        if (strings.length == 0) {
                            Bukkit.getLogger().info("実行したコマンドのサブコマンドが空欄です。");
                            commandSender.sendMessage("§4実行したコマンドのサブコマンドが空欄です。");
                            return false;
                        } else if (strings.length == 1) {
                            if (strings[0].equalsIgnoreCase("red")) {
                                QuickQuizGame.getInstance().getConfig().set("redstone.red.x", player.getLocation().getX());
                                QuickQuizGame.getInstance().getConfig().set("redstone.red.y", player.getLocation().getY());
                                QuickQuizGame.getInstance().getConfig().set("redstone.red.z", player.getLocation().getZ());
                                QuickQuizGame.getInstance().saveConfig();

                                player.sendMessage("redのレッドストーン位置を§6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.red.x") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.red.y") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.red.z") + "§rに設定しました。");
                                return true;
                            }
                            if (strings[0].equalsIgnoreCase("blue")) {
                                QuickQuizGame.getInstance().getConfig().set("redstone.blue.x", player.getLocation().getX());
                                QuickQuizGame.getInstance().getConfig().set("redstone.blue.y", player.getLocation().getY());
                                QuickQuizGame.getInstance().getConfig().set("redstone.blue.z", player.getLocation().getZ());
                                QuickQuizGame.getInstance().saveConfig();

                                player.sendMessage("blueのレッドストーン位置を§6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.x") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.y") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.z") + "§rに設定しました。");
                                return true;
                            }
                            if (strings[0].equalsIgnoreCase("yellow")) {
                                QuickQuizGame.getInstance().getConfig().set("redstone.yellow.x", player.getLocation().getX());
                                QuickQuizGame.getInstance().getConfig().set("redstone.yellow.y", player.getLocation().getY());
                                QuickQuizGame.getInstance().getConfig().set("redstone.yellow.z", player.getLocation().getZ());
                                QuickQuizGame.getInstance().saveConfig();

                                player.sendMessage("yellowのレッドストーン位置を§6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.x") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.y") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.z") + "§rに設定しました。");
                                return true;
                            }
                            if (strings[0].equalsIgnoreCase("green")) {
                                QuickQuizGame.getInstance().getConfig().set("redstone.green.x", player.getLocation().getX());
                                QuickQuizGame.getInstance().getConfig().set("redstone.green.y", player.getLocation().getY());
                                QuickQuizGame.getInstance().getConfig().set("redstone.green.z", player.getLocation().getZ());
                                QuickQuizGame.getInstance().saveConfig();

                                player.sendMessage("greenのレッドストーン位置を§6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.green.x") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.green.y") + " " + QuickQuizGame.getInstance().getConfig().getInt("redstone.green.z") + "§rに設定しました。");
                                return true;
                            }
                        }
                    }
                }
                return false;
            } else {
                commandSender.sendMessage("§4ゲームが開始されているため実行できません。");
                return false;
            }
        } else {
            commandSender.sendMessage("§4OPを所持していないプレイヤーはこのコマンドの実行ができません。");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setpos")) {
            if (strings.length == 1) {
                if (strings[0].length() == 0) {
                    return Arrays.asList("red", "blue", "yellow", "green");
                } else {
                    if ("red".startsWith(strings[0])) {
                        return Collections.singletonList("red");
                    } else if ("blue".startsWith(strings[0])) {
                        return Collections.singletonList("blue");
                    } else if ("yellow".startsWith(strings[0])) {
                        return Collections.singletonList("yellow");
                    } else if ("green".startsWith(strings[0])) {
                        return Collections.singletonList("green");
                    }
                }
            }
        }
        return List.of();
    }
}
