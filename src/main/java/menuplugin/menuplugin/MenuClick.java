package menuplugin.menuplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.Map;
import java.util.UUID;

import static menuplugin.menuplugin.SettingsLoad.*;


public class MenuClick {

    public void menuClick(InventoryClickEvent event){

        UUID playerUUID = event.getWhoClicked().getUniqueId();
        Player player = Bukkit.getPlayer(playerUUID);
        int openingPage = playerOpening.get(player.getName());
        int clickSlot = event.getRawSlot();

        String key = openingPage+","+clickSlot;

        if(interactPageItem.containsKey(key)){
            //exists the key and value
            int jumpToPage = interactPageItem.get(key);
            playerOpening.remove(player.getName());
            playerOpening.put(player.getName(),jumpToPage);
            Inventory inventory = inventoryAndPage.get(jumpToPage);
            player.openInventory(inventory);

            String commandKey = openingPage+","+clickSlot;
            if(slotAndCommand.containsKey(commandKey)){
                for (String loop : slotAndCommand.get(commandKey)){
                    if(!(loop.equals(""))){
                        player.chat(loop);
                    }

                }

            }
        }

    }
}
