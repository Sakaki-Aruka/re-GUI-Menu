package menuplugin.menuplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static menuplugin.menuplugin.SettingsLoad.inventoryAndPage;
import static menuplugin.menuplugin.SettingsLoad.playerOpening;

public class MenuOpen {


    public void menuOpen(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(event.getAction()==Action.RIGHT_CLICK_AIR && player.getInventory().getItemInMainHand().getType()== Material.STICK){
            // a player has sticks and right click.
            // a player is opening first inventory page
            playerOpening.put(player.getName(),1);
            player.openInventory(inventoryAndPage.get(1));
        }
    }
}
