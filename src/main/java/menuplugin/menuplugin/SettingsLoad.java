package menuplugin.menuplugin;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
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

    public static ArrayList<Integer> slots = new ArrayList<>();
    public static ArrayList<Integer> slot = new ArrayList<>();
    public static ArrayList<String> materialName = new ArrayList<>();
    public static ArrayList<String> displayName = new ArrayList<>();
    public static ArrayList<String> lore = new ArrayList<>();
    public static ArrayList<Integer> amount = new ArrayList<>();
    public static ArrayList<String> storageName = new ArrayList<>();

    public static Map<String,String> jumpPage = new HashMap<>();
    public static ArrayList<String> jumpInfoArray = new ArrayList<>();

    public void configLoad(){
        pages = FC.getInt("pages");
        for (int page=1;page <= pages;page++){

            slots.add(FC.getInt("page"+page+".slots"));
            items = FC.getInt("page"+page+".items");
            storageName.add(FC.getString("page"+page+".storageName"));
            for (int item=1;item <= items; item++){

                String category = "page"+page+".item"+item;
                slot.add(FC.getInt(category+".slot"));
                materialName.add(FC.getString(category+".materialName"));
                displayName.add(FC.getString(category+".displayName"));
                lore.add(FC.getString(category+".lore"));
                amount.add(FC.getInt(category+".amount"));


                if(FC.contains(category+".jump")){
                    String pageAndItem = page+","+item;
                    // key; jump from
                    // value; jump to
                    jumpPage.put(pageAndItem,category+".jump");
                    jumpInfoArray.add(pageAndItem);
                }
            }

        }
    }

    public ArrayList<String> getMaterialName(){
        return materialName;
    }

    public ArrayList<String> getDisplayName(){
        return displayName;
    }

    public ArrayList<String> getLore(){
        return lore;
    }

    public ArrayList<Integer> getAmount(){
        return amount;
    }

    public ArrayList<String> getStorageName(){
        return storageName;
    }

    public ArrayList<Integer> getSlots(){
        return slots;
    }

    public ArrayList<Integer> getSlot(){
        return slot;
    }

}
