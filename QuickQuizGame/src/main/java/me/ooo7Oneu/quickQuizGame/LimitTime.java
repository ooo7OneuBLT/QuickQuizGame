package me.ooo7Oneu.quickQuizGame;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class LimitTime extends JavaPlugin {

    static int seconds;
    static Boolean stop = false;

    public static void startLimitTime(int limit) {

        seconds = limit;

        new BukkitRunnable() {

            @Override
            public void run() {
                if (!stop) {
                    if (0 < seconds) {
                        if (QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                //p.sendMessage("§3残り§6" + seconds + "§3秒です。");
                                TextComponent component = new TextComponent();
                                component.setText("§3残り§6" + seconds + "§3秒です。");
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                            }
                        }
                        seconds = seconds - 1;
                    } else {
                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            onlinePlayers.sendMessage("§5時間制限により問題をスキップします。");
                            onlinePlayers.playSound(onlinePlayers, Sound.BLOCK_ENDER_CHEST_CLOSE, 1, 1);
                        }
                        press.resetPress();
                        GUICommand.startedQuestion = false;
                        cancel();
                    }
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(QuickQuizGame.getInstance(), 0, 20);
    }
}
