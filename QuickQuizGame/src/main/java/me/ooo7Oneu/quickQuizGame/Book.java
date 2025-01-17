package me.ooo7Oneu.quickQuizGame;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;

public class Book extends JavaPlugin {
    public static ItemStack getBook() {
        ItemStack book = new ItemStack(Material.BOOK, 1);
        ItemMeta bookMeta = book.getItemMeta();
        bookMeta.setDisplayName("§5出題者GUI");
        book.setItemMeta(bookMeta);
        return book;
    }
}
