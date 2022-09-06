package menuplugin.menuplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class MenuPlugin extends JavaPlugin {

    public void load(){
        FileConfiguration fileConfiguration = getConfig();
        new SettingsLoad().fc(fileConfiguration);
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.load();
        getServer().getPluginManager().registerEvents(new Events(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
