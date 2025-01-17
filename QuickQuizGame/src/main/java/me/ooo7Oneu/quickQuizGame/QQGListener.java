package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class QQGListener implements Listener {

    //本の右クリックを検知
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();
        if (!(player.getInventory().getItemInMainHand().getItemMeta() == null)) {
            if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(Book.getBook().getItemMeta())) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().equals(Book.getBook().getItemMeta())) {
                        //Bukkit.getLogger().info(player.getDisplayName() + "が出題者GUIを開きました。");
                        //Bukkit.getLogger().info("startedGame: " + GUICommand.startedGame + "  startedQuetion: " + GUICommand.startedQuestion);
                    /*    if (PressList.pressList.isEmpty()) {
                            Bukkit.getLogger().info("pressListがnullです。");
                        } else {
                            Bukkit.getLogger().info("pressListがnullではありません。" + PressList.pressList.toString());
                        } */
                        player.performCommand("qqg open gui");
                    }
                }
            }
        }
    }
}
