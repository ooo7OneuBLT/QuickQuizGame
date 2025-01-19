package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.Set;

public class SettingGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        boolean chance = true;

        if (player.hasMetadata("OpenedSettingGUI")) {
            event.setCancelled(true);
            if (SettingGUI.defaultPage) {
                //時間制限の設定
                if (event.getSlot() == 10) {
                    player.closeInventory();
                    SettingGUI.defaultPage = false;
                    SettingGUI.settingPage = true;
                    SettingGUI.openSettingGUI(player);
                    player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                }

                //config.ymlの書き出し
                if (event.getSlot() == 16) {
                    player.closeInventory();
                    Config.export(player);
                    player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                }

                //performerGUIに戻る
                if (event.getSlot() == 24) {
                    player.closeInventory();
                    GUICommand.openGUI(player, null, null, null);
                    player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                }
            }
            if (SettingGUI.settingPage) {
                if (QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
                    if (event.getSlot() == 13) {
                        player.closeInventory();
                        QuickQuizGame.getInstance().getConfig().set("countDownDisplay", false);
                        QuickQuizGame.getInstance().saveConfig();
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.sendMessage("§5カウントダウンの表示を§4オフ§5にしました。");
                        }
                        SettingGUI.openSettingGUI(player);
                        player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                    }
                } else if (!QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
                    if (event.getSlot() == 13) {
                        player.closeInventory();
                        QuickQuizGame.getInstance().getConfig().set("countDownDisplay", true);
                        QuickQuizGame.getInstance().saveConfig();
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.sendMessage("§5カウントダウンの表示を§aオン§5にしました。");
                        }
                        SettingGUI.openSettingGUI(player);
                        player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                    }
                }

                if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") == 0) {
                    if (event.getSlot() == 11) {
                        player.closeInventory();
                        SettingGUI.isLimitTime = true;
                        QuickQuizGame.getInstance().getConfig().set("limitTime", 30);
                        QuickQuizGame.getInstance().saveConfig();
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.sendMessage("§5時間制限を§aオン§5にしました。(デフォルト:30秒)");
                        }
                        SettingGUI.openSettingGUI(player);
                        player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                        chance = false;
                    }
                }
                if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") > 0) {
                    if (chance) {
                        if (event.getSlot() == 11) {
                            player.closeInventory();
                            SettingGUI.isLimitTime = false;
                            QuickQuizGame.getInstance().getConfig().set("limitTime", 0);
                            QuickQuizGame.getInstance().saveConfig();
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.sendMessage("§5時間制限を§4オフ§5にしました。");
                            }
                            SettingGUI.openSettingGUI(player);
                            player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                        }
                    }
                    //30秒
                    if (event.getSlot() == 19) {
                        player.closeInventory();
                        SettingGUI.isTrue1m = false;
                        SettingGUI.isTrue30s = true;
                        QuickQuizGame.getInstance().getConfig().set("limitTime", 30);
                        QuickQuizGame.getInstance().saveConfig();
                        player.sendMessage("§5制限時間を§630秒§5に設定しました。");
                        SettingGUI.openSettingGUI(player);
                        player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                    }
                    //1分
                    if (event.getSlot() == 20) {
                        player.closeInventory();
                        SettingGUI.isTrue30s = false;
                        SettingGUI.isTrue1m = true;
                        QuickQuizGame.getInstance().getConfig().set("limitTime", 60);
                        QuickQuizGame.getInstance().saveConfig();
                        player.sendMessage("§5制限時間を§61分§5に設定しました。");
                        SettingGUI.openSettingGUI(player);
                        player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                    }
                }
                if (event.getSlot() == 25) {
                    player.closeInventory();
                    SettingGUI.settingPage = false;
                    SettingGUI.defaultPage = true;
                    SettingGUI.openSettingGUI(player);
                    player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                }
            }
        }

    }
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if(player.hasMetadata("OpenedSettingGUI")) {
            player.removeMetadata("OpenedSettingGUI", QuickQuizGame.getInstance());
        }
    }
}
