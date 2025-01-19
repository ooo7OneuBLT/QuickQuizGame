package me.ooo7Oneu.quickQuizGame;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class GuiListener implements Listener {

    public static BukkitTask task;

    @EventHandler
    public static void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player.hasMetadata("OpnedPerformerGUI")) {
            event.setCancelled(true);

            //ゲームスタート後
            if (GUICommand.startedGame) {

                //問題が始まる前
                if (!GUICommand.startedQuestion) {
                    //開始
                    if (event.getSlot() == 10) {
                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            onlinePlayers.sendMessage("§5問題を開始します。");
                        }

                        LimitTime.stop = false;

                        if (SettingGUI.isLimitTime) {
                            if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") != 0) {
                                LimitTime.startLimitTime(QuickQuizGame.getInstance().getConfig().getInt("limitTime"));
                            }
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.sendMessage("§5制限時間は§6" + QuickQuizGame.getInstance().getConfig().getInt("limitTime") + "§5秒です。");
                            }
                        }

                        PressList.removeAllList();

                        GUICommand.startedQuestion = true;
                        player.closeInventory();
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.playSound(onlinePlayer, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                        }
                    }

                    //終了
                    if (event.getSlot() == 12) {
                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            onlinePlayers.sendMessage("§4ゲームを終了しました。");
                            onlinePlayers.sendMessage("§5最終結果");
                            onlinePlayers.sendMessage("§c赤チーム§r: " + Score.redScore + "§5点");
                            onlinePlayers.sendMessage("§9青チーム§r: " + Score.blueScore + "§5点");
                            onlinePlayers.sendMessage("§6黄色チーム§r: " + Score.yellowScore + "§5点");
                            onlinePlayers.sendMessage("§2緑チーム§r: " + Score.greenScore + "§5点");
                            onlinePlayers.playSound(onlinePlayers, Sound.ENTITY_ENDER_DRAGON_DEATH, 1, 1);
                        }
                        press.resetPress();
                        GUICommand.startedGame = false;
                        if (task != null && !task.isCancelled()) {
                            task.cancel();
                        }
                        player.closeInventory();
                    }
                }

                //問題が始まった後
                if (GUICommand.startedQuestion) {

                    //回答ボタンが押されていない時
                    //if (!press.isPressedRed && !press.isPressedBlue && !press.isPressedYellow && !press.isPressedGreen) {
                    if (PressList.pressList.isEmpty()) {
                        //
                        if (event.getSlot() == 16) {

                            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                                onlinePlayers.sendMessage("§5問題をスキップしました。");
                                onlinePlayers.playSound(onlinePlayers, Sound.BLOCK_ENDER_CHEST_CLOSE, 1, 1);
                            }
                            press.resetPress();
                            player.closeInventory();
                            LimitTime.stop = true;
                            GUICommand.startedQuestion = false;
                        }
                    }

                    //回答ボタンが押されている時
                    //if (press.isPressedRed || press.isPressedBlue || press.isPressedYellow || press.isPressedGreen) {
                    if (!PressList.pressList.isEmpty()) {
                        if (event.getSlot() == 10) {
                            player.sendMessage("§6回答を正解にしました。");
                            player.closeInventory();
                            if (PressList.pressList.getFirst().equals("red")) {
                                Score.addScore("red");
                                press.resetPress();
                            }
                            if (PressList.pressList.getFirst().equals("blue")) {
                                Score.addScore("blue");
                                press.resetPress();
                            }
                            if (PressList.pressList.getFirst().equals("yellow")) {
                                Score.addScore("yellow");
                                press.resetPress();
                            }
                            if (PressList.pressList.getFirst().equals("green")) {
                                Score.addScore("green");
                                press.resetPress();
                            }
                            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                                onlinePlayers.playSound(onlinePlayers, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                                onlinePlayers.sendTitle("§6正解", "");
                            }
                            Score.updateScoreboard(player);
                            GUICommand.startedQuestion = false;
                            Bukkit.getScheduler().cancelTask(1);
                            PressList.removeAllList();
                        }
                        if (event.getSlot() == 12) {
                            player.sendMessage("§4回答を不正解にしました。");
                            press.resetPress();
                            player.closeInventory();
                            PressList.removeList(PressList.pressList.getFirst());
                            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                                onlinePlayers.playSound(onlinePlayers, Sound.ENTITY_ENDERMAN_DEATH, 1, 1);
                                onlinePlayers.sendTitle("§4不正解", "");
                            }
                            if (SettingGUI.isLimitTime) {
                                LimitTime.stop = false;
                                LimitTime.startLimitTime(QuickQuizGame.getInstance().getConfig().getInt("limitTime"));
                            }
                        }
                    }
                }
            }

            //ゲームスタート前
            if (!GUICommand.startedGame) {

                //開始
                if (event.getSlot() == 10) {
                    Score.redScore = 0;
                    Score.blueScore = 0;
                    Score.yellowScore = 0;
                    Score.greenScore = 0;
                    player.sendMessage("§5ゲームが開始を開始しました。");
                    GUICommand.startedGame = true;
                    player.closeInventory();
                    for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                        onlineplayer.sendTitle("§6ゲーム開始", "");
                        Score.createScoreboard(onlineplayer);
                        onlineplayer.playSound(onlineplayer, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
                    }
                }

                //設定
                if (event.getSlot() == 25) {
                    player.closeInventory();
                    GUICommand.isSetting = true;
                    //SettingGUI.defaultPage = true;
                    SettingGUI.openSettingGUI(player);
                    player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
                }
            }



        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if(player.hasMetadata("OpnedPerformerGUI"))
            player.removeMetadata("OpnedPerformerGUI", QuickQuizGame.getInstance());
    }

    //drop book cancel
    @EventHandler
    public void onDropBook(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack dropItem = event.getItemDrop().getItemStack();
        if (dropItem.equals(Book.getBook())) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.DARK_RED + "出題者GUIをすてないでください。");
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        ItemStack itemC = event.getCursor();
        if ((!(item == null)) && (!(itemC == null))) {
            if (item.equals(Book.getBook())) {
                event.setCancelled(true);
                player.performCommand("qqg open gui");
            }
            if (itemC.equals(Book.getBook())) {
                event.setCancelled(true);
            }
        }
    }

}
