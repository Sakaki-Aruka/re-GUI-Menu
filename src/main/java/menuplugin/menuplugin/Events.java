package menuplugin.menuplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        new MenuOpen().menuOpen(event);
    }
}
