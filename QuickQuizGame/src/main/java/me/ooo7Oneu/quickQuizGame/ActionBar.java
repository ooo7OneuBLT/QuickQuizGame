package me.ooo7Oneu.quickQuizGame;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBar extends BukkitRunnable {

    @Override
    public void run() {

        if (!PressList.pressList.isEmpty()) {

            //if (press.isPressedRed) {
            if (PressList.pressList.getFirst().equals("red")) {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    TextComponent component = new TextComponent();
                    component.setText("§c§l赤チームが回答中...");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                }

            }
            //if (press.isPressedBlue) {
            if (PressList.pressList.getFirst().equals("blue")) {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    TextComponent component = new TextComponent();
                    component.setText("§9§l青チームが回答中...");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                }

            }
            //if (press.isPressedYellow) {
            if (PressList.pressList.getFirst().equals("yellow")) {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    TextComponent component = new TextComponent();
                    component.setText("§6§l黄色チームが回答中...");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                }

            }
            //if (press.isPressedGreen) {
            if (PressList.pressList.getFirst().equals("green")) {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    TextComponent component = new TextComponent();
                    component.setText("§2§l緑チームが回答中...");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                }

            }
        }
    }
}
