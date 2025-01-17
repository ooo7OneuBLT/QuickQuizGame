package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

public class runnable extends BukkitRunnable {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Scoreboard scoreboard = player.getScoreboard();
                if (scoreboard != null) {
                    Score.updateScoreboard(player);
                } else {
                    Bukkit.getLogger().info("scoreboard is null");
                }
            }
        }
}
