package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class QuickQuizGame extends JavaPlugin {

    public static QuickQuizGame instance;

    public static int redstoneRedX = 0;
    public static int redstoneRedY = 0;
    public static int redstoneRedZ = 0;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("QuickQuizGameが正常にロードされました。");
        Bukkit.getLogger().info("[QuickQuizGame] version:" + checkVersion());

        saveDefaultConfig();
        Config.upload();

        setInstance(this);

        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new QQGListener(), this);
        getServer().getPluginManager().registerEvents(new SettingGUIListener(), this);

        instance = this;

        getCommand("press").setExecutor(new press());
        getCommand("setpos").setExecutor(new SetRedStonePos());
        getCommand("qqg").setExecutor(new QQG());

        redstoneRedX = getConfig().getInt("redstone.red.x");
        redstoneRedY = getConfig().getInt("redstone.red.y");
        redstoneRedZ = getConfig().getInt("redstone.red.z");

        if (getConfig().getInt("limitTime") == 0) {
            SettingGUI.isLimitTime = false;
        } else {
            SettingGUI.isLimitTime = true;
        }

        QQG.performer = getConfig().getString("performer");

    }

    public static QuickQuizGame getInstance() {

        return getPlugin(QuickQuizGame.class);
    }

    private static void setInstance(QuickQuizGame instance) {

        QuickQuizGame.instance = instance;
    }

    @Override
    public void onDisable() {
        getConfig().set("performer", QQG.performer);
        saveConfig();
    }

    static String checkVersion() {
        return "1.1";
    }

}
