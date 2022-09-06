package menuplugin.menuplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuOpen {
    public void menuOpen(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(event.getAction()==Action.RIGHT_CLICK_AIR || event.getAction()==Action.RIGHT_CLICK_BLOCK && player.getInventory().getItemInMainHand().getType()== Material.STICK){
            // a player has sticks and right click
            SettingsLoad load = new SettingsLoad();
            ArrayList<Integer> slots = load.getSlots();
            ArrayList<String> storageName = load.getStorageName();
            Material firstMaterial = Material.valueOf(load.getMaterialName().get(0));

            String LoreStr = load.getLore().get(0);
            ArrayList<String> firstLore = new ArrayList<>(Arrays.asList(LoreStr.split(",")));

            // set first gui menu
            Inventory inventory = Bukkit.createInventory(null,slots.get(0),storageName.get(0));
            ItemStack itemStack = new ItemStack(firstMaterial);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(load.getDisplayName().get(0));
            itemMeta.setLore(firstLore);
            itemStack.setItemMeta(itemMeta);

            itemStack.setAmount(load.getAmount().get(0));
            inventory.setItem(load.getSlot().get(0),itemStack);

            player.openInventory(inventory);

        }
    }
}
