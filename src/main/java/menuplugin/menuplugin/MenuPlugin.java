package menuplugin.menuplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


import static menuplugin.menuplugin.SettingsLoad.*;

public final class MenuPlugin extends JavaPlugin implements CommandExecutor {

    public void load(){
        FileConfiguration fileConfiguration = getConfig();
        new SettingsLoad().fc(fileConfiguration);
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.load();
        getServer().getPluginManager().registerEvents(new Events(),this);
        getCommand("guimenureload").setExecutor(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if(sender.isOp()){
            sender.sendMessage("§cGUI-Menu plugin is updating contents now.");

            // clear maps
            interactPageItem.clear();
            inventoryAndPage.clear();
            slotAndCommand.clear();
            arrayCommand.clear();

            reloadConfig();
            this.load();

            sender.sendMessage("§bGUI-Menu plugin has finished updated.");
            return true;
        }else{
            sender.sendMessage("§cCannot use.");
            return false;
        }

    }
}
