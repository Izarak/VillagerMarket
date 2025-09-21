package net.bestemor.villagermarket.command.subcommand;

import net.bestemor.core.command.ISubCommand;
import net.bestemor.villagermarket.VMPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.time.Instant;
import java.util.List;

public class AutoDiscountsCommand implements ISubCommand {

    final VMPlugin vmPlugin;

    public AutoDiscountsCommand(VMPlugin vmPlugin) {
        this.vmPlugin = vmPlugin;
    }

    @Override
    public List<String> getCompletion(String[] strings) {
        return List.of();
    }

    @Override
    public void run(CommandSender commandSender, String[] strings) {
        commandSender.sendMessage(ChatColor.GREEN + "Setting new discounts! " + ChatColor.RED + "This doesn't remove old discounts.");
        vmPlugin.getShopManager().setNextAutoDiscount(Instant.now());
    }

    @Override
    public String getDescription() {
        return "Forces Auto-Discounts to be given again. This does not remove discounts from items.";
    }

    @Override
    public String getUsage() {
        return "";
    }
}
