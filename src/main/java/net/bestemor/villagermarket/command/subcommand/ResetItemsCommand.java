package net.bestemor.villagermarket.command.subcommand;

import net.bestemor.core.command.ISubCommand;
import net.bestemor.villagermarket.VMPlugin;
import net.bestemor.villagermarket.shop.ShopItem;
import net.bestemor.villagermarket.shop.VillagerShop;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ResetItemsCommand implements ISubCommand {

    final VMPlugin main;

    public ResetItemsCommand(VMPlugin main) {
        this.main = main;
    }

    @Override
    public List<String> getCompletion(String[] strings) {
        return List.of();
    }

    @Override
    public void run(CommandSender commandSender, String[] strings) {
        for (VillagerShop shop : main.getShopManager().getShops()) {
            shop.getShopfrontHolder().getItemList().values().forEach(ShopItem::resetCooldown);
        }
        commandSender.sendMessage(ChatColor.GREEN + "Resetting cooldowns for all items.");
    }

    @Override
    public String getDescription() {
        return "Forces items to reset.";
    }

    @Override
    public String getUsage() {
        return "";
    }
}
