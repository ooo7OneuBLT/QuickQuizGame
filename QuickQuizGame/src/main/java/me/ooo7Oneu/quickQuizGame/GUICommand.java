package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public class GUICommand extends JavaPlugin {

    static Boolean startedGame = false;
    static Boolean startedQuestion = false;
    static Boolean isSetting = false;

    public static boolean openGUI(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("プレイヤーのみ実行可能です。");
            return true;
        }

        Player player = (Player) sender;

        Inventory inventory = Bukkit.createInventory(player, 9 * 4, "§ePERFORMER GUI");

        //ゲーム開始後
        if (startedGame) {

            //問題が始まる前
            if (!startedQuestion) {

                    //開始
                    ItemStack start = new ItemStack(Material.SPECTRAL_ARROW);
                    ItemMeta startMeta = start.getItemMeta();
                    if (!(startMeta == null)) {
                        startMeta.setDisplayName("§5問題を開始する(回答を可能にします。)");
                    }
                    start.setItemMeta(startMeta);
                    inventory.setItem(10, start);



                    //終了
                    ItemStack quit = new ItemStack(Material.REDSTONE_BLOCK);
                    ItemMeta quitMeta = quit.getItemMeta();
                    if (!(quitMeta == null)) {
                        quitMeta.setDisplayName("§4ゲームを終了する。");
                    }
                    quit.setItemMeta(quitMeta);
                    inventory.setItem(12, quit);

                    //red
            /*        ItemStack red = new ItemStack(Material.RED_WOOL);
                    ItemMeta redMeta = red.getItemMeta();
                    if (redMeta != null) {
                        redMeta.setDisplayName("§c赤チームに回答権を与える");
                    }
                    red.setItemMeta(redMeta);
                    inventory.setItem(23, red);

                    //blue
                    ItemStack blue = new ItemStack(Material.BLUE_WOOL);
                    ItemMeta blueMeta = blue.getItemMeta();
                    if (blueMeta != null) {
                        blueMeta.setDisplayName("§9青チームに回答権を与える");
                    }
                    blue.setItemMeta(blueMeta);
                    inventory.setItem(24, blue);

                    //yellow
                    ItemStack yellow = new ItemStack(Material.YELLOW_WOOL);
                    ItemMeta yellowMeta = yellow.getItemMeta();
                    if (yellowMeta != null) {
                        yellowMeta.setDisplayName("§6黄色チームに回答権を与える");
                    }
                    yellow.setItemMeta(yellowMeta);
                    inventory.setItem(25, yellow);

                    //green
                    ItemStack green = new ItemStack(Material.GREEN_WOOL);
                    ItemMeta greenMeta = green.getItemMeta();
                    if (greenMeta != null) {
                        greenMeta.setDisplayName("§2緑チームに回答権を与える");
                    }
                    green.setItemMeta(greenMeta);
                    inventory.setItem(26, green); */
            }

            //問題が始まった後
            if (startedQuestion) {

                //回答ボタンが押されていない時
                //if (!press.isPressedRed && !press.isPressedBlue && !press.isPressedYellow && !press.isPressedGreen) {
                if (PressList.pressList.isEmpty()) {
                    ItemStack pass = new ItemStack(Material.ARROW);
                    ItemMeta passMeta = pass.getItemMeta();
                    if (!(passMeta == null)) {
                        passMeta.setDisplayName("§5問題をスキップする。");
                    }
                    pass.setItemMeta(passMeta);
                    inventory.setItem(16,pass);
                }

                //回答ボタンが押されている時
                //if (press.isPressedRed || press.isPressedBlue || press.isPressedYellow || press.isPressedGreen) {
                if (!PressList.pressList.isEmpty()) {

                    //正解
                    ItemStack correct = new ItemStack(Material.SUNFLOWER);
                    ItemMeta correctMeta = correct.getItemMeta();
                    if (!(correctMeta == null)) {
                        correctMeta.setDisplayName("§6正解");
                    }
                    correct.setItemMeta(correctMeta);
                    inventory.setItem(10, correct);

                    //不正解
                    ItemStack wrong = new ItemStack(Material.STRUCTURE_VOID);
                    ItemMeta wrongMeta = wrong.getItemMeta();
                    if (!(wrongMeta == null)) {
                        wrongMeta.setDisplayName("§4不正解");
                    }
                    wrong.setItemMeta(wrongMeta);
                    inventory.setItem(12, wrong);
                }
            }
        }

        //ゲーム開始前
        if (!startedGame) {

            //開始
            ItemStack start = new ItemStack(Material.IRON_SWORD);
            ItemMeta correctMeta = start.getItemMeta();
            if (!(correctMeta == null)) {
                correctMeta.setDisplayName("§5ゲームを開始する");
            }
            start.setItemMeta(correctMeta);
            inventory.setItem(10, start);

            //設定
            ItemStack setting = new ItemStack(Material.ANVIL);
            ItemMeta settingMeta = setting.getItemMeta();
            if (!(settingMeta == null)) {
                settingMeta.setDisplayName("§5設定");
            }
            setting.setItemMeta(settingMeta);
            inventory.setItem(25,setting);
        }

        player.openInventory(inventory);
        player.setMetadata("OpnedPerformerGUI", new FixedMetadataValue(QuickQuizGame.getInstance(), "PerformerGUI"));
        return false;
    }
}
