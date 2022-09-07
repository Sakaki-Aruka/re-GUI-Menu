package menuplugin.menuplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SettingsLoad {

    private static FileConfiguration FC;

    public void fc(FileConfiguration fileConfiguration){
        FC = fileConfiguration;
        this.configLoad();
    }

    private static int pages;
    private static int items;

    public static Map<String,Integer> playerOpening = new HashMap<>();
    public static Map<String,Integer> interactPageItem = new HashMap<>();
    public static Map<Integer,Inventory> inventoryAndPage = new HashMap<>();
    public static Map<String,ArrayList<String>> slotAndCommand = new HashMap<>();


    public void configLoad(){
        pages = FC.getInt("pages");
        for (int page=1;page <= pages;page++){

            items = FC.getInt("page"+page+".items");
            int inventorySize = FC.getInt("page"+page+".slots");
            String storageName = FC.getString("page"+page+".storageName");
            Inventory inventory = Bukkit.createInventory(null,inventorySize,storageName);

            for (int item=1;item <= items; item++){
                String category = "page"+page+".item"+item;

                int slot = FC.getInt(category+".slot");
                String key = page+","+slot;
                int value = FC.getInt(category+".jump");
                if(value==0){
                    interactPageItem.put(key,page);
                }else{
                    interactPageItem.put(key,value);
                }

                if(FC.contains(category+".command")){
                    String commandKey = page+","+slot;
                    String commandValue = FC.getString(category+".command");
                    ArrayList<String> array = new ArrayList<>(Arrays.asList(commandValue.split("!&!")));
                    slotAndCommand.put(commandKey,array);
                    //debug
                    System.out.println(slotAndCommand);
                }


                Material material = Material.valueOf(FC.getString(category+".materialName"));
                String displayName = FC.getString(category+".displayName");
                ArrayList<String> lore = new ArrayList<>(Arrays.asList(FC.getString(category+".lore").split("!&!")));
                int amount = FC.getInt(category+".amount");

                ItemStack itemStack = new ItemStack(material);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(displayName);
                itemMeta.setLore(lore);
                itemStack.setItemMeta(itemMeta);
                itemStack.setAmount(amount);
                inventory.setItem(slot,itemStack);

            }
            inventoryAndPage.put(page,inventory);

        }
    }

}
