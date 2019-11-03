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
        this.configFile.addDefault("Configuration.Maintenance.CustomSlot", false);
        this.configFile.addDefault("Message.Prefix", "&8[&bEasyMaintenance&8] &7");
        this.configFile.addDefault("Message.NoPermissions", "&7Du hast keine &cRechte &7dazu&8.");
        this.configFile.addDefault("Message.Enabled", "&7Der §bWartungsmodus &7wurde &aaktiviert&8.");
        this.configFile.addDefault("Message.Disabled", "&7Der &bWartungsmodus &7wurde &cdeaktiviert&8.");
        this.configFile.addDefault("Message.Disallow", "&7Der &bServer &7befindet sich derzeit in &bWartungsarbeiten&8.");
        this.configFile.addDefault("Message.AlreadyAdded", "&7Der &bSpieler &7wurde bereits hinzugefügt&8.");
        this.configFile.addDefault("Message.NotAdded", "&7Der &bSpieler &7wurde noch nicht hinzugefügt&8.");
        this.configFile.addDefault("Message.SuccessfullyAdded", "&b%player% &7wurde erfolgreich hinzugefügt&8.");
        this.configFile.addDefault("Message.SuccessfullyRemoved", "&b%player% &7wurde erfolgreich entfernt&8.");
        this.configFile.addDefault("Message.List", " &8-> &b%player%");
        this.configFile.addDefault("Message.ListEmpty", "&7Es befindet sich derzeit kein &bSpieler &7auf der &bWhitelist&8.");
        this.configFile.addDefault("Message.Serverlist.1", "&8 ● &bDeinServer&8.&bde &8┃ &7Dein &bMinecraft &7Server &8┃ &b1&8.&b8 &8- &b1&8.&b14");
        this.configFile.addDefault("Message.Serverlist.2", "&8  ➥ &7Status&8: &cWartungsarbeiten &8┃ &7Twitter&8: &7@&bDeinServer");

    }

    private EasyMaintenance getInstance() { return this.instance; }
    public FileManager getConfigFile() { return this.configFile; }

}
