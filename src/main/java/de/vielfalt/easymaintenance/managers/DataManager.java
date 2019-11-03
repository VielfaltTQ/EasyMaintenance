package de.vielfalt.easymaintenance.managers;

import de.vielfalt.easymaintenance.EasyMaintenance;

import java.util.ArrayList;

public class DataManager {

    private EasyMaintenance instance;
    private FileManager configFile;

    public DataManager(EasyMaintenance instance) {

        this.instance = instance;
        this.configFile = new FileManager("plugins//EasyMaintenance//config.yml");

    }

    public void write() {

        this.configFile.addDefault("Configuration.Maintenance.State", false);
        this.configFile.addDefault("Configuration.Maintenance.Whitelist", new ArrayList<String>());
        this.configFile.addDefault("Configuration.Maintenance.Customslot", false);
        this.configFile.addDefault("Message.Prefix", "&8[&bEasyMaintenance&8] &7");
        this.configFile.addDefault("Message.NoPermissions", "&cDu hast keine Rechte dazu!");
        this.configFile.addDefault("Message.Disallow", "&cDer Server ist derzeit in Wartungen!");
        this.configFile.addDefault("Message.Serverlist.1", "&c&k||&r &bDeinServer&8.&bde &8| &b1&8.&b8 &8- &b1&8.&b14 &c&k||");
        this.configFile.addDefault("Message.Serverlist.2", "&cDer Server ist derzeit in Wartungen!");

    }

    private EasyMaintenance getInstance() { return this.instance; }
    public FileManager getConfigFile() { return this.configFile; }

}
