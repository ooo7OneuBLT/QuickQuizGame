package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class Score extends JavaPlugin {

    static int redScore = 0;
    static int blueScore = 0;
    static int yellowScore = 0;
    static int greenScore = 0;

    public static void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("score", "dummy");
        objective.setDisplayName("スコア");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team red = board.registerNewTeam("red");
        red.addEntry("§c赤チーム: ");
        red.setSuffix("");
        red.setPrefix("");
        objective.getScore("§c赤チーム").setScore(redScore);

        Team blue = board.registerNewTeam("blue");
        blue.addEntry("§9青チーム: ");
        blue.setSuffix("");
        blue.setPrefix("");
        objective.getScore("§9青チーム").setScore(blueScore);

        Team yellow = board.registerNewTeam("yellow");
        yellow.addEntry("§6黄色チーム: ");
        yellow.setSuffix("");
        yellow.setPrefix("");
        objective.getScore("§6黄色チーム").setScore(yellowScore);

        Team green = board.registerNewTeam("green");
        green.addEntry("§a緑チーム: ");
        green.setSuffix("");
        green.setPrefix("");
        objective.getScore("§a緑チーム").setScore(greenScore);

        player.setScoreboard(board);
    }

    public static void updateScoreboard(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("score");
        if (objective != null) {
            objective.getScore("§c赤チーム").setScore(redScore);
            objective.getScore("§9青チーム").setScore(blueScore);
            objective.getScore("§6黄色チーム").setScore(yellowScore);
            objective.getScore("§a緑チーム").setScore(greenScore);
        }
    }

    public static void addScore(String team) {
        if (team.equals("red")) {
            redScore = redScore + 1;
        }
        if (team.equals("blue")) {
            blueScore = blueScore + 1;
        }
        if (team.equals("yellow")) {
            yellowScore = yellowScore + 1;
        }
        if (team.equals("green")) {
            greenScore = greenScore + 1;
        }
    }

}
