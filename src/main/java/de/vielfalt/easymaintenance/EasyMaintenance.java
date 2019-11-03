package de.vielfalt.easymaintenance;

import de.vielfalt.easymaintenance.api.EasyMaintenanceAPI;
import de.vielfalt.easymaintenance.commands.EasyMaintenanceCommand;
import de.vielfalt.easymaintenance.listeners.PlayerLoginListener;
import de.vielfalt.easymaintenance.listeners.ServerListPingListener;
import de.vielfalt.easymaintenance.managers.DataManager;
import de.vielfalt.easymaintenance.managers.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyMaintenance extends JavaPlugin {

    private static EasyMaintenance instance;
    private DataManager dataManager;
    private MessageManager messageManager;
    private EasyMaintenanceAPI easyMaintenanceAPI;

    @Override
    public void onEnable() {

        instance = this;

        this.dataManager = new DataManager(getInstance());
        this.dataManager.write();
        this.messageManager = new MessageManager(getInstance());
        this.easyMaintenanceAPI = new EasyMaintenanceAPI(getInstance());

        register();

    }

    private void register() {

        new EasyMaintenanceCommand(getInstance(), "easymaintenance");
        new PlayerLoginListener(getInstance());
        new ServerListPingListener(getInstance());

    }

    public static EasyMaintenance getInstance() { return instance; }
    public DataManager getDataManager() { return this.dataManager; }
    public MessageManager getMessageManager() { return this.messageManager; }
    public EasyMaintenanceAPI getEasyMaintenanceAPI() { return this.easyMaintenanceAPI; }

}
