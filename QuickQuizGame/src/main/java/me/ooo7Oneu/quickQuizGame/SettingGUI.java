package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public class SettingGUI extends JavaPlugin {

    static Boolean defaultPage = true;
    static Boolean settingPage = false;
    static Boolean isLimitTime = false;
    static Boolean isTrue30s = false;
    static Boolean isTrue1m = false;
    static Inventory inventory;

    public static void openSettingGUI(Player player) {

        inventory = Bukkit.createInventory(player, 9 * 4, "§5settingGUI");

        if (defaultPage) {
            //時間制限設定
            ItemStack limitTimeSetting = new ItemStack(Material.CLOCK);
            ItemMeta limitTimeSettingItemMeta = limitTimeSetting.getItemMeta();
            if (!(limitTimeSettingItemMeta == null)) {
                limitTimeSettingItemMeta.setDisplayName("§5時間制限の設定");
            }
            limitTimeSetting.setItemMeta(limitTimeSettingItemMeta);
            inventory.setItem(10, limitTimeSetting);

            //config.ymlの書き出し
            ItemStack config = new ItemStack(Material.JIGSAW);
            ItemMeta configItemMeta = config.getItemMeta();
            if (!(configItemMeta == null)) {
                configItemMeta.setDisplayName("§5設定の確認(config.ymlの書き出し)");
            }
            config.setItemMeta(configItemMeta);
            inventory.setItem(16, config);

            //performerGUIに戻る
            ItemStack backPerformerGUI = new ItemStack(Material.ARROW);
            ItemMeta bakcPerformerGUIItemMeta = backPerformerGUI.getItemMeta();
            if (!(bakcPerformerGUIItemMeta == null)) {
                bakcPerformerGUIItemMeta.setDisplayName("§5出題者GUIに戻る");
            }
            backPerformerGUI.setItemMeta(bakcPerformerGUIItemMeta);
            inventory.setItem(24, backPerformerGUI);
        }
        if (settingPage) {

            if (QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
                ItemStack countDownDisplay = new ItemStack(Material.LIME_DYE);
                ItemMeta countDownDisplayItemMeta = countDownDisplay.getItemMeta();
                if (!(countDownDisplayItemMeta == null)) {
                    countDownDisplayItemMeta.setDisplayName("§aカウントダウンの表示:オン");
                }
                countDownDisplay.setItemMeta(countDownDisplayItemMeta);
                inventory.setItem(13, countDownDisplay);
            } else if (!QuickQuizGame.getInstance().getConfig().getBoolean("countDownDisplay")) {
                ItemStack countDownDisplay = new ItemStack(Material.GRAY_DYE);
                ItemMeta countDownDisplayItemMeta = countDownDisplay.getItemMeta();
                if (!(countDownDisplayItemMeta == null)) {
                    countDownDisplayItemMeta.setDisplayName("§4カウントダウンの表示:オフ");
                }
                countDownDisplay.setItemMeta(countDownDisplayItemMeta);
                inventory.setItem(13, countDownDisplay);
            }

            if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") == 0) {
                ItemStack offLimitTime = new ItemStack(Material.GRAY_DYE);
                ItemMeta offLimitTimeItemMeta = offLimitTime.getItemMeta();
                if (!(offLimitTimeItemMeta == null)) {
                    offLimitTimeItemMeta.setDisplayName("§4時間制限設定:オフ");
                }
                offLimitTime.setItemMeta(offLimitTimeItemMeta);
                inventory.setItem(11, offLimitTime);
            }
            if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") > 0) {
                ItemStack onLimitTime = new ItemStack(Material.LIME_DYE);
                ItemMeta onLimitTimeItemMeta = onLimitTime.getItemMeta();
                if (!(onLimitTimeItemMeta == null)) {
                    onLimitTimeItemMeta.setDisplayName("§a時間制限設定:オン");
                }
                onLimitTime.setItemMeta(onLimitTimeItemMeta);
                inventory.setItem(11, onLimitTime);

                //30秒
                if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") == 30) {
                    ItemStack s30 = new ItemStack(Material.LIME_DYE);
                    ItemMeta s30ItemMeta = s30.getItemMeta();
                    if (!(s30ItemMeta == null)) {
                        s30ItemMeta.setDisplayName("§730秒");
                    }
                    s30.setItemMeta(s30ItemMeta);
                    inventory.setItem(19, s30);
                } else {
                    ItemStack s30 = new ItemStack(Material.GRAY_DYE);
                    ItemMeta s30ItemMeta = s30.getItemMeta();
                    if (!(s30ItemMeta == null)) {
                        s30ItemMeta.setDisplayName("§730秒");
                    }
                    s30.setItemMeta(s30ItemMeta);
                    inventory.setItem(19, s30);
                }

                //１分
                if (QuickQuizGame.getInstance().getConfig().getInt("limitTime") == 60) {
                    ItemStack m1 = new ItemStack(Material.LIME_DYE);
                    ItemMeta m1ItemMeta = m1.getItemMeta();
                    if (!(m1ItemMeta == null)) {
                        m1ItemMeta.setDisplayName("§71分");
                    }
                    m1.setItemMeta(m1ItemMeta);
                    inventory.setItem(20, m1);
                } else {
                    ItemStack m1 = new ItemStack(Material.GRAY_DYE);
                    ItemMeta m1ItemMeta = m1.getItemMeta();
                    if (!(m1ItemMeta == null)) {
                        m1ItemMeta.setDisplayName("§71分");
                    }
                    m1.setItemMeta(m1ItemMeta);
                    inventory.setItem(20, m1);
                }
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta backItemMeta = back.getItemMeta();
            if (!(backItemMeta == null)) {
                backItemMeta.setDisplayName("§5戻る");
            }
            back.setItemMeta(backItemMeta);
            inventory.setItem(25, back);
        }

        player.openInventory(inventory);
        player.setMetadata("OpenedSettingGUI", new FixedMetadataValue(QuickQuizGame.getInstance(), "SettingGUI"));

    }
}
