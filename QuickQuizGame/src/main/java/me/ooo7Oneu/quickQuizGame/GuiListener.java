package me.ooo7Oneu.quickQuizGame;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

public class GuiListener implements Listener {

    public static BukkitTask task;

    @EventHandler
    public void onClick(InventoryClickEvent event) {
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
                        }
                        press.resetPress();
                        GUICommand.startedGame = false;
                        if (task != null && !task.isCancelled()) {
                            task.cancel();
                        }
                        player.closeInventory();
                    }

                    //red
                /*    if (event.getSlot() == 23) {
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.sendMessage("§c赤チームに回答権が与えられました。");
                        }

                        QuickQuizGame.getInstance().reloadConfig();
                        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.red.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.red.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.red.z") - 1);
                        location.getBlock().setType(Material.REDSTONE_BLOCK);
                        press.isPressedRed = true;
                        GUICommand.startedQuestion = true;
                        player.closeInventory();
                        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);

                    }

                    //blue
                    if (event.getSlot() == 24) {
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.sendMessage("§9青チームに回答権が与えられました。");
                        }

                        QuickQuizGame.getInstance().reloadConfig();
                        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.blue.z") - 1);
                        location.getBlock().setType(Material.REDSTONE_BLOCK);
                        press.isPressedBlue = true;
                        GUICommand.startedQuestion = true;
                        player.closeInventory();
                        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);

                    }

                    //yellow
                    if (event.getSlot() == 25) {
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.sendMessage("§6黄色チームに回答権が与えられました。");
                        }

                        QuickQuizGame.getInstance().reloadConfig();
                        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.yellow.z") - 1);
                        location.getBlock().setType(Material.REDSTONE_BLOCK);
                        press.isPressedYellow = true;
                        GUICommand.startedQuestion = true;
                        player.closeInventory();
                        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);

                    }

                    //green
                    if (event.getSlot() == 26) {
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.sendMessage("§2緑チームに回答権が与えられました。");
                        }

                        QuickQuizGame.getInstance().reloadConfig();
                        Location location = new Location(Bukkit.getWorld("World"), QuickQuizGame.getInstance().getConfig().getInt("redstone.green.x") - 1, QuickQuizGame.getInstance().getConfig().getInt("redstone.green.y") - 2, QuickQuizGame.getInstance().getConfig().getInt("redstone.green.z") - 1);
                        location.getBlock().setType(Material.REDSTONE_BLOCK);
                        press.isPressedGreen = true;
                        GUICommand.startedQuestion = true;
                        player.closeInventory();
                        new ActionBar().runTaskTimer(QuickQuizGame.getInstance(), 0, 20);

                    } */

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
                            }
                            press.resetPress();
                            player.closeInventory();
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
                        }
                    }
                }
            }

            //ゲームスタート前
            if (!GUICommand.startedGame) {
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
