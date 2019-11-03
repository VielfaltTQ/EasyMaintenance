package de.vielfalt.easymaintenance.commands;

import de.vielfalt.easymaintenance.EasyMaintenance;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class EasyMaintenanceCommand implements CommandExecutor {

    private EasyMaintenance instance;

    public EasyMaintenanceCommand(EasyMaintenance instance, String command) {

        this.instance = instance;
        this.instance.getCommand(command).setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("easymaintenance.use")) {

            if(args.length == 3) {

                if(args[0].equalsIgnoreCase("whitelist")) {

                    if(args[1].equalsIgnoreCase("add")) {

                        if(!getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist")
                                .contains(Bukkit.getOfflinePlayer(args[2]).getUniqueId().toString())) {

                            List<String> whiteList = getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist");
                            whiteList.add(Bukkit.getOfflinePlayer(args[2]).getUniqueId().toString());
                            getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.Whitelist", whiteList);
                            sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager()
                                    .getMessage("SuccessfullyAdded", Bukkit.getOfflinePlayer(args[2]).getName()));

                        } else { sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("AlreadyAdded")); }

                    } else if(args[1].equalsIgnoreCase("remove")) {

                        if(getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist")
                                .contains(Bukkit.getOfflinePlayer(args[2]).getUniqueId().toString())) {

                            List<String> whiteList = getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist");
                            whiteList.remove(Bukkit.getOfflinePlayer(args[2]).getUniqueId().toString());
                            getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.Whitelist", whiteList);
                            sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager()
                                    .getMessage("SuccessfullyRemoved", Bukkit.getOfflinePlayer(args[2]).getName()));

                        } else { sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("NotAdded")); }

                    } else { sendUsage(sender); }

                } else { sendUsage(sender); }

            } else if(args.length == 2) {

                if(args[0].equalsIgnoreCase("whitelist")) {

                    if(args[1].equalsIgnoreCase("list")) {

                        List<String> whiteList = getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist");

                        if(whiteList.size() > 0) {

                            sender.sendMessage("");

                            for(int i = 0; i < whiteList.size(); i++) {

                                sender.sendMessage(getInstance().getMessageManager().getMessage("List", Bukkit.getOfflinePlayer(UUID.fromString(whiteList.get(i))).getName()));

                            }

                            sender.sendMessage("");

                        } else { sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("ListEmpty")); }

                    } else { sendUsage(sender); }

                } else { sendUsage(sender); }

            } else if(args.length == 1) {

                if(args[0].equalsIgnoreCase("changestate")) {

                    if(getInstance().getDataManager().getConfigFile().getBoolean("Configuration.Maintenance.State")) {

                        getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.State", false);
                        sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("Disabled"));

                    } else {

                        getInstance().getDataManager().getConfigFile().set("Configuration.Maintenance.State", true);
                        sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("Enabled"));

                        for(Player onlinePlayers : Bukkit.getOnlinePlayers()) {

                            if(!getInstance().getDataManager().getConfigFile().getStringList("Configuration.Maintenance.Whitelist")
                                    .contains(onlinePlayers.getUniqueId().toString())) {

                                onlinePlayers.kickPlayer(getInstance().getMessageManager().getMessage("Disallow"));

                            }

                        }

                    }

                } else { sendUsage(sender); }

            } else { sendUsage(sender); }

        } else { sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("NoPermissions")); }

        return true;
    }

    private void sendUsage(CommandSender sender) {

        sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + "§8/§bEasyMaintenance §echangestate");
        sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + "§8/§bEasyMaintenance §ewhitelist list");
        sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + "§8/§bEasyMaintenance §ewhitelist add §8<§eSpielername§8>");
        sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + "§8/§bEasyMaintenance §ewhitelist remove §8<§eSpielername§8>");

    }

    private EasyMaintenance getInstance() { return this.instance; }

}
