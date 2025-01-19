package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetBlockRedStone extends JavaPlugin {
    public static void redSetBlockRedStone() {
        QuickQuizGame.getInstance().reloadConfig();
        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.red.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.red.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.red.z") - 1);
        location.getBlock().setType(Material.REDSTONE_BLOCK);
        press.isPressedRed = true;
        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);
    }
    public static void blueSetBlockRedStone() {
        QuickQuizGame.getInstance().reloadConfig();
        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.z") - 1);
        location.getBlock().setType(Material.REDSTONE_BLOCK);
        press.isPressedBlue = true;
        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);
    }
    public static void yellowSetBlockRedStone() {
        QuickQuizGame.getInstance().reloadConfig();
        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.z") - 1);
        location.getBlock().setType(Material.REDSTONE_BLOCK);
        press.isPressedYellow = true;
        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);
    }
    public static void greenSetBlockRedStone() {
        QuickQuizGame.getInstance().reloadConfig();
        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.green.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.green.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.green.z") - 1);
        location.getBlock().setType(Material.REDSTONE_BLOCK);
        press.isPressedGreen = true;
        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);
    }
}
