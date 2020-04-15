package com.fr.matrax.simplecreator.commands;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import com.fr.matrax.simplecreator.items.CustomItem;
import com.fr.matrax.simplecreator.items.DefaultCustomItem;
import com.fr.matrax.simplecreator.managers.CustomItemManager;

public class CustomItemCommand {
	
	/**
	 * This method use the command for create a new custom item
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void createItemCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.createitem") == true || player.isOp())
		{
			if(args.length == 2)
			{
				if(CustomItemManager.getCustomItemManager().contains(args[1]) == true)
				{
					player.sendMessage("§cThis custom item already exist !");
					return;
				}
				
				DefaultCustomItem customItem = new DefaultCustomItem(args[1]);
				customItem.load();
				player.sendMessage("§aYou created the custom item §e" + customItem.getName());
			} else {
				player.sendMessage("§cDo /mtxlib createitem {name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for give a custom item
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void giveItemCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.giveitem") == true || player.isOp())
		{
			if(args.length == 2)
			{
				CustomItem customItem = CustomItemManager.getCustomItemManager().getByName(args[1]);
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customItem.give(player.getInventory());
				player.sendMessage("§aYou give the custom item §e" + customItem.getName());
			} else {
				player.sendMessage("§cDo /mtxlib giveitem {name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	
	/**
	 * This method use the command for set the custom item name
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setItemNameCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setitemname") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[1]);
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customItem.setDisplayName(args[2]);
				customItem.getCustomItemFile().set("display_name", args[2]);
				customItem.getCustomItemFile().save();
				player.sendMessage("§aThe custom item §e" + customItem.getName() + "§a hsa a new name : §a" + args[2]);
			} else {
				player.sendMessage("§cDo /mtxlib setitemname {name} {display name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the amount of a custom item
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setAmountCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setamount") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[1]);
				int amount = Integer.valueOf(args[2]);
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				if(amount < 0)
				{
					player.sendMessage("§cAmount > 0 !");
					return;
				}
				
				customItem.setAmount(amount);
				customItem.getCustomItemFile().set("amount", amount);
				customItem.getCustomItemFile().save();
				player.sendMessage("§aThe custom item §e" + customItem.getName() + "§a amount is : §a" + amount);
			} else {
				player.sendMessage("§cDo /mtxlib setamount {name} {amount}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the custom item unbreakable
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setUnbreakableCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setunbreakable") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[1]);
				boolean unbreakable = Boolean.valueOf(args[2]);
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customItem.setUnbreakable(unbreakable);
				customItem.getCustomItemFile().set("unbreakable", unbreakable);
				customItem.getCustomItemFile().save();
				player.sendMessage("§aThe custom item §e" + customItem.getName() + "§a is unbreakable : " + unbreakable);
			} else {
				player.sendMessage("§cDo /mtxlib setunbreakable {name} {amount}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the material of a custom item
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setItemMaterialCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setitemmaterial") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[1]);
				Material material = Material.valueOf(args[2].toUpperCase());
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				if(material == null)
				{
					player.sendMessage("§cThis material doesn't exist !");
					return;
				}
				
				customItem.setMaterial(material);
				customItem.getCustomItemFile().set("material", args[2].toUpperCase());
				customItem.getCustomItemFile().save();
				player.sendMessage("§aThe custom item §e" + customItem.getName() + "§a material is : " + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib setitemmaterial {name} {material}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for add a new enchantment on a custom item
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void addEnchantmentCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.addenchantment") == true || player.isOp())
		{
			if(args.length == 4)
			{
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[1]);
				@SuppressWarnings("deprecation")
				Enchantment enchantment = Enchantment.getByName(args[2].toUpperCase());
				int level = Integer.valueOf(args[3]);
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				if(enchantment == null)
				{
					player.sendMessage("§cThis enchantment doesn't exist !");
					return;
				}
				
				if(level < 1)
				{
					player.sendMessage("§cLevel > 1 !");
					return;
				}
				
				List<String> enchantments = customItem.getCustomItemFile().getStringList("enchantments");
				enchantments.add(args[2].toUpperCase() + ":" + level);
				customItem.getEnchantments().put(enchantment, level);
				customItem.getCustomItemFile().set("enchantments", enchantments);
				customItem.getCustomItemFile().save();
				player.sendMessage("§aThe custom item §e" + customItem.getName() + "§a has a new enchantment is : " + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib addenchantment {name} {enchantment} {level}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for add a flag on a custom item
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void addFlagCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.addflag") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[1]);
				ItemFlag itemFlag = ItemFlag.valueOf(args[2].toUpperCase());
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				if(itemFlag == null)
				{
					player.sendMessage("§cThis item flag doesn't exist !");
					return;
				}
				
				List<String> flags = customItem.getCustomItemFile().getStringList("flags");
				flags.add(args[2].toUpperCase());
				customItem.getFlags().add(itemFlag);
				customItem.getCustomItemFile().set("flags", flags);
				customItem.getCustomItemFile().save();
				player.sendMessage("§aThe custom item §e" + customItem.getName() + "§a has a new flag : " + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib addflag {name} {flag}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
}
