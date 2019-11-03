package de.vielfalt.easymaintenance.managers;

import de.vielfalt.easymaintenance.EasyMaintenance;
import org.bukkit.entity.Player;

public class MessageManager {

    private EasyMaintenance instance;

    public MessageManager(EasyMaintenance instance) {

        this.instance = instance;

    }

    public String getMessage(String message) {

        return getInstance().getDataManager().getConfigFile().getString("Message." + message).replaceAll("&", "§");

    }

    public String getMessage(String message, String playername) {

        return getInstance().getDataManager().getConfigFile().getString("Message." + message).replaceAll("&", "§")
                .replaceAll("%player%", playername);

    }

    private EasyMaintenance getInstance() { return this.instance; }

}
