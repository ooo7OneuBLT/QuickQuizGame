package me.ooo7Oneu.quickQuizGame;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Config extends JavaPlugin {
    public static void upload() {
        if (!QuickQuizGame.getInstance().getConfig().contains("redstone.red")) {
            QuickQuizGame.getInstance().getConfig().set("redstone.red.x", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.red.y", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.red.z", 0);
        }
        if (!QuickQuizGame.getInstance().getConfig().contains("redstone.blue")) {
            QuickQuizGame.getInstance().getConfig().set("redstone.blue.x", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.blue.y", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.blue.z", 0);
        }
        if (!QuickQuizGame.getInstance().getConfig().contains("redstone.yellow")) {
            QuickQuizGame.getInstance().getConfig().set("redstone.yellow.x", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.yellow.y", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.yellow.z", 0);
        }
        if (!QuickQuizGame.getInstance().getConfig().contains("redstone.green")) {
            QuickQuizGame.getInstance().getConfig().set("redstone.green.x", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.green.y", 0);
            QuickQuizGame.getInstance().getConfig().set("redstone.green.z", 0);
        }
        if (!QuickQuizGame.getInstance().getConfig().contains("performer")) {
            QuickQuizGame.getInstance().getConfig().set("performer", null);
        }
        if (!QuickQuizGame.getInstance().getConfig().contains("limitTime")) {
            QuickQuizGame.getInstance().getConfig().set("limitTime", 0);
        }
        if (!QuickQuizGame.getInstance().getConfig().contains("countDownDisplay")) {
            QuickQuizGame.getInstance().getConfig().set("countDownDisplay", false);
        }
    }

    public static void export(Player player) {
        player.sendMessage("§5config.yml");
        player.sendMessage("§4レッドストーンブロックの位置:");
        player.sendMessage("§c赤チーム: §5X: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.red.x") + " §5Y: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.red.y") + " §5Z: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.red.z"));
        player.sendMessage("§9青チーム: §5X: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.x") + " §5Y: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.y") + " §5Z: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.z"));
        player.sendMessage("§6黄色チーム: §5X: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.x") + " §5Y: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.y") + " §5Z: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.z"));
        player.sendMessage("§2緑チーム: §5X: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.green.x") + " §5Y: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.green.y") + " §5Z: §6" + QuickQuizGame.getInstance().getConfig().getInt("redstone.green.z"));
        player.sendMessage("§5出題者: §6" + QuickQuizGame.getInstance().getConfig().getString("performer"));
        if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") == 0) {
            player.sendMessage("§5制限時間: §4オフ");
        } else player.sendMessage("§5制限時間: §aオン §5: §6" + QuickQuizGame.getInstance().getConfig().getInt("limitTime"));
        if (QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
            player.sendMessage("§5カウントダウンの表示: §aオン");
        } else if (!QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
            player.sendMessage("§5カウントダウンの表示: §4オフ");
        } else player.sendMessage("§4入力内容が適切ではありません。");
    }
}
