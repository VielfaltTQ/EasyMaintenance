package de.vielfalt.easymaintenance.listeners;

import de.vielfalt.easymaintenance.EasyMaintenance;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener {

    private EasyMaintenance instance;

    public ServerListPingListener(EasyMaintenance instance) {

        this.instance = instance;
        Bukkit.getPluginManager().registerEvents(this, this.instance);

    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {

        if(getInstance().getDataManager().getConfigFile().getBoolean("Configuration.Maintenance.State")) {

            event.setMotd(getInstance().getMessageManager().getMessage("Serverlist.1") + "\n"
                    + getInstance().getMessageManager().getMessage("Serverlist.2"));

            if(getInstance().getDataManager().getConfigFile().getBoolean("Configuration.Maintenance.CustomSlot")) {
                event.setMaxPlayers((Bukkit.getOnlinePlayers().size() + 1)); }

        }

    }

    private EasyMaintenance getInstance() { return this.instance; }

}
