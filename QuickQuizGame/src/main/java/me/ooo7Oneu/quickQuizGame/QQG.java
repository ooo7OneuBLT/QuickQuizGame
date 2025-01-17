package me.ooo7Oneu.quickQuizGame;

import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class QQG implements CommandExecutor, TabCompleter {

    static String performer;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("qqg")) {
            if (strings.length == 0) {
                Bukkit.getLogger().info("実行したコマンドのサブコマンドが空欄です。");
                commandSender.sendMessage("§4実行したコマンドのサブコマンドが空欄です。");
                return false;
            } else if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("reload")) {
                    QuickQuizGame.getInstance().reloadConfig();
                    commandSender.sendMessage("QuickQuizGameをリロードしました。");
                    return true;
                }
            } else if (strings.length == 2) {

                if (strings[0].equalsIgnoreCase("get")) {
                    if (strings[1].equalsIgnoreCase("gui")) {
                        if (commandSender.getName().equals(performer)) {
                            Player player = (Player) commandSender;
                            player.getInventory().removeItem(Book.getBook());
                            player.getInventory().setItem(0, Book.getBook());
                            return true;
                        } else {
                            commandSender.sendMessage("§4出題者以外がこのコマンドを実行することはできません。");
                        }
                    }
                } else if (strings[0].equalsIgnoreCase("open")) {
                    if (strings[1].equalsIgnoreCase("gui")) {
                        //commandSender.sendMessage("guiを開きます");
                        GUICommand.openGUI(commandSender, command, s, strings);
                        return GUICommand.openGUI(commandSender, command, s, strings);
                    }
                } else if (strings[0].equalsIgnoreCase("set")) {
                    if (strings[1].equalsIgnoreCase("performer")) {
                        commandSender.sendMessage("§4設定するプレイヤー名を入力してください");
                        return false;
                    }
                }

            } else if (strings.length == 3) {
                if (strings[0].equalsIgnoreCase("set")) {
                    if (strings[1].equalsIgnoreCase("performer")) {
                        if (commandSender.isOp()) {
                            performer = strings[2];
                            commandSender.sendMessage("§5出題者を §6" + performer + "§5 に設定しました。");
                            return true;
                        } else {
                            commandSender.sendMessage("§4OPを所持しているプレイヤーのみ実行可能です。");
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("qqg")) {
            if (strings.length == 1) {
                if (strings[0].length() == 0) {
                    return Arrays.asList("reload", "get", "open", "set");
                } else {
                    if ("reload".startsWith(strings[0])) {
                        return Collections.singletonList("reload");
                    } else if ("get".startsWith(strings[0])) {
                        return Collections.singletonList("get");
                    } else if ("open".startsWith(strings[0])) {
                        return Collections.singletonList("open");
                    } else if ("set".startsWith(strings[0])) {
                        return Collections.singletonList("set");
                    }
                }
            } else if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("get")) {
                    if (strings[1].length() == 0) {
                        return Arrays.asList("gui");
                    } else {
                        if ("gui".startsWith(strings[1])) {
                            return Collections.singletonList("gui");
                        }
                    }
                } else if (strings[0].equalsIgnoreCase("open")) {
                    if (strings[1].length() == 0) {
                        return Arrays.asList("gui");
                    } else {
                        if ("gui".startsWith(strings[1])) {
                            return Collections.singletonList("gui");
                        }
                    }
                } else if (strings[0].equalsIgnoreCase("set")) {
                    if (strings[1].length() == 0) {
                        return Arrays.asList("performer");
                    } else {
                        if ("performer".startsWith(strings[1])) {
                            return Collections.singletonList("performer");
                        }
                    }
                    if (strings[2].length() == 0) {
                        List<String> list = new ArrayList<>();
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            list.add(p.getName());
                        }
                        Bukkit.getLogger().info(list.toString());
                        return list;
                    }
                }
            }
        }
        return List.of();
    }
}
