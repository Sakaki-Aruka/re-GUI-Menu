package menuplugin.menuplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        new MenuOpen().menuOpen(event);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        new MenuClick().menuClick(event);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        new MenuClose().close(event);
    }
}
