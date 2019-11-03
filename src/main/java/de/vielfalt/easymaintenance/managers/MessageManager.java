package de.vielfalt.easymaintenance.managers;

import de.vielfalt.easymaintenance.EasyMaintenance;

public class MessageManager {

    private EasyMaintenance instance;

    public MessageManager(EasyMaintenance instance) {

        this.instance = instance;

    }

    public String getMessage(String message) {

        return getInstance().getDataManager().getConfigFile().getString("Message." + message).replaceAll("&", "§");

    }

    private EasyMaintenance getInstance() { return this.instance; }

}
