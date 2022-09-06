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
import java.util.HashMap;
import java.util.Map;

import static menuplugin.menuplugin.SettingsLoad.inventoryAndPage;
import static menuplugin.menuplugin.SettingsLoad.playerOpening;

public class MenuOpen {


    public void menuOpen(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(event.getAction()==Action.RIGHT_CLICK_AIR || event.getAction()==Action.RIGHT_CLICK_BLOCK && player.getInventory().getItemInMainHand().getType()== Material.STICK){
            // a player has sticks and right click
            SettingsLoad load = new SettingsLoad();

            // a player is opening first inventory page
            playerOpening.put(player.getName(),1);
            player.openInventory(inventoryAndPage.get(1));
        }
    }
}
