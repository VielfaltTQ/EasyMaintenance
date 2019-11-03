package de.vielfalt.easymaintenance.commands;

import de.vielfalt.easymaintenance.EasyMaintenance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EasyMaintenanceCommand implements CommandExecutor {

    private EasyMaintenance instance;

    public EasyMaintenanceCommand(EasyMaintenance instance, String command) {

        this.instance = instance;
        this.instance.getCommand(command).setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // /EasyMaintenance changestate
        // /EasyMaintenance whitelist list
        // /EasyMaintenance whitelist add <Playername>
        // /EasyMaintenance whitelist remove <Playername>

        if(sender.hasPermission("easymaintenance.use")) {

            if(args.length == 3) {

                if(args[0].equalsIgnoreCase("whitelist")) {

                    if(args[1].equalsIgnoreCase("add")) {

                        

                    } else if(args[1].equalsIgnoreCase("remove")) {



                    } else { sendUsage(sender); }

                } else { sendUsage(sender); }

            } else if(args.length == 2) {



            } else if(args.length == 1) {

                if(args[0].equalsIgnoreCase("changestate")) {



                } else { sendUsage(sender); }

            } else { sendUsage(sender); }

        } else {

            sender.sendMessage(getInstance().getMessageManager().getMessage("Prefix") + getInstance().getMessageManager().getMessage("NoPermissions"));

        }

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
