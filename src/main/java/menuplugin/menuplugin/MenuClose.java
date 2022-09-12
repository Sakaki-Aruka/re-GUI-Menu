package menuplugin.menuplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

import static menuplugin.menuplugin.MenuOpen.openingPlayers;

public class MenuClose {
    public void close(InventoryCloseEvent event){
        UUID uuid = event.getPlayer().getUniqueId();
        Player player = Bukkit.getPlayer(uuid);

        openingPlayers.remove(player.getName());
    }
}
