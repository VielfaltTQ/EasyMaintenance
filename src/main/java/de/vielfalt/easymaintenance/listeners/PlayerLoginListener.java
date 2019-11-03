package de.vielfalt.easymaintenance.listeners;

import de.vielfalt.easymaintenance.EasyMaintenance;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements Listener {

    private EasyMaintenance instance;

    public PlayerLoginListener(EasyMaintenance instance) {

        this.instance = instance;
        Bukkit.getPluginManager().registerEvents(this, this.instance);

    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {

        Player player = event.getPlayer();

        if(getInstance().getDataManager().getConfigFile().getBoolean("Configuration.Maintenance.State")) {

            if(!getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist").contains(player.getUniqueId().toString())) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, getInstance().getMessageManager().getMessage("Disallow")); }

        }

    }

    private EasyMaintenance getInstance() { return this.instance; }

}
