package de.vielfalt.easymaintenance.api;

import de.vielfalt.easymaintenance.EasyMaintenance;
import org.bukkit.Bukkit;

import java.util.List;

public class EasyMaintenanceAPI {

    private EasyMaintenance instance;

    public EasyMaintenanceAPI(EasyMaintenance instance) {

        this.instance = instance;

    }

    public void changeState(Boolean value) { getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.State", value); }

    public void addWhitelist(String playername) {

        if(!getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist")
                .contains(Bukkit.getOfflinePlayer(playername).getUniqueId().toString())) {

            List<String> whiteList = getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist");
            whiteList.add(Bukkit.getOfflinePlayer(playername).getUniqueId().toString());
            getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.Whitelist", whiteList);

        }

    }

    public void removeWhitelist(String playername) {

        if(getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist")
                .contains(Bukkit.getOfflinePlayer(playername).getUniqueId().toString())) {

            List<String> whiteList = getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist");
            whiteList.remove(Bukkit.getOfflinePlayer(playername).getUniqueId().toString());
            getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.Whitelist", whiteList);

        }

    }

    public Boolean getState() { return getInstance().getDataManager().getConfigFile().getBoolean("Configuration.Maintenance.State"); }
    public List<String> getWhiteList() { return getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.List"); }

    private EasyMaintenance getInstance() { return this.instance; }

}
