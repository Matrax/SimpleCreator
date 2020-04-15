package com.fr.matrax.simplecreator.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager implements CommandExecutor 
{
	
	private static CommandManager commandManager;
	
	private JavaPlugin plugin;
	
	/**
	 * Constructor of the class CommandManager
	 * @param plugin The instance of the plugin
	 */
	public CommandManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
		commandManager = this;
	}
	
	/**
	 * This function return the instance of the command manager
	 * @return The instance of the command manager
	 */
	public static CommandManager getCommandManager() {
		return commandManager;
	}
	
	/**
	 * This method load the command manager
	 */
	public void load()
	{
		this.plugin.getCommand("simplecreator").setExecutor(this);
	}
	
	/**
	 * This method unload the command manager
	 */
	public void unload()
	{
		this.plugin.getCommand("simplecreator").setExecutor(null);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) 
	{
		if(command.getName().equalsIgnoreCase("simplecreator"))
		{
			Player player = (Player) sender;
			if(args.length == 0)
			{
				player.sendMessage("");
				player.sendMessage("§6=========SimpleCreator Version:" + this.plugin.getDescription().getVersion() + "=========");
				player.sendMessage("§9Plugin by _Matrax_");
				player.sendMessage("§a/simplecreator");
				player.sendMessage("§a/simplecreator reload");
				player.sendMessage("§a/simplecreator help item");
				player.sendMessage("§a/simplecreator help mob");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("help")) this.helpCommand(player, args);
			if(args[0].equalsIgnoreCase("reload")) this.reloadCommand(player, args);
			if(args[0].equalsIgnoreCase("createmob")) CustomMobCommand.createMobCommand(player, args);
			if(args[0].equalsIgnoreCase("spawnmob")) CustomMobCommand.spawnMobCommand(player, args);
			if(args[0].equalsIgnoreCase("mobinfo")) CustomMobCommand.infoMobCommand(player, args);
			if(args[0].equalsIgnoreCase("setmobname")) CustomMobCommand.setMobNameCommand(player, args);
			if(args[0].equalsIgnoreCase("setai")) CustomMobCommand.setAICommand(player, args);
			if(args[0].equalsIgnoreCase("setcollidable")) CustomMobCommand.setCollidableCommand(player, args);
			if(args[0].equalsIgnoreCase("setgliding")) CustomMobCommand.setGlidingCommand(player, args);
			if(args[0].equalsIgnoreCase("setglowing")) CustomMobCommand.setGlowingCommand(player, args);
			if(args[0].equalsIgnoreCase("setgravity")) CustomMobCommand.setGravityCommand(player, args);
			if(args[0].equalsIgnoreCase("setdefaultdrop")) CustomMobCommand.setDefaultDropCommand(player, args);
			if(args[0].equalsIgnoreCase("sethealth")) CustomMobCommand.setHealthCommand(player, args);
			if(args[0].equalsIgnoreCase("setdroppedxp")) CustomMobCommand.setDroppedXpCommand(player, args);
			if(args[0].equalsIgnoreCase("setfireticks")) CustomMobCommand.setFireTicksCommand(player, args);
			if(args[0].equalsIgnoreCase("settype")) CustomMobCommand.setTypeCommand(player, args);
			if(args[0].equalsIgnoreCase("sethelmet")) CustomMobCommand.setHelmetCommand(player, args);
			if(args[0].equalsIgnoreCase("setchestplate")) CustomMobCommand.setChestplateCommand(player, args);
			if(args[0].equalsIgnoreCase("setleggings")) CustomMobCommand.setLeggingsCommand(player, args);
			if(args[0].equalsIgnoreCase("setboots")) CustomMobCommand.setBootsCommand(player, args);
			if(args[0].equalsIgnoreCase("setmainhand")) CustomMobCommand.setMainHandCommand(player, args);
			if(args[0].equalsIgnoreCase("setoffhand")) CustomMobCommand.setOffHandCommand(player, args);
			if(args[0].equalsIgnoreCase("addpotioneffect")) CustomMobCommand.addPotionEffectCommand(player, args);
			if(args[0].equalsIgnoreCase("adddrop")) CustomMobCommand.addDropCommand(player, args);
			
			if(args[0].equalsIgnoreCase("createitem")) CustomItemCommand.createItemCommand(player, args);
			if(args[0].equalsIgnoreCase("giveitem")) CustomItemCommand.giveItemCommand(player, args);
			if(args[0].equalsIgnoreCase("setitemname")) CustomItemCommand.setItemNameCommand(player, args);
			if(args[0].equalsIgnoreCase("setitemmaterial")) CustomItemCommand.setItemMaterialCommand(player, args);
			if(args[0].equalsIgnoreCase("setunbreakable")) CustomItemCommand.setUnbreakableCommand(player, args);
			if(args[0].equalsIgnoreCase("setamount")) CustomItemCommand.setAmountCommand(player, args);
			if(args[0].equalsIgnoreCase("addenchantment")) CustomItemCommand.addEnchantmentCommand(player, args);
			if(args[0].equalsIgnoreCase("addflag")) CustomItemCommand.addFlagCommand(player, args);
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method use the command for display the help on the chat
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public void helpCommand(Player player, String[] args)
	{
		if(player.hasPermission("simplecreator.command.help") == true || player.isOp())
		{
			if(args.length == 2)
			{
				if(args[1].equalsIgnoreCase("mob"))
				{
					player.sendMessage("");
					player.sendMessage("§6=========Mobs=========");
					player.sendMessage("§a/simplecreator createmob (name)");
					player.sendMessage("§a/simplecreator spawnmob (name)");
					player.sendMessage("§a/simplecreator mobinfo (name)");
					player.sendMessage("§a/simplecreator settype (name) (entity type)");
					player.sendMessage("§a/simplecreator setai (name) (true / false)");
					player.sendMessage("§a/simplecreator setcollidable (name) (true / false)");
					player.sendMessage("§a/simplecreator setgliding (name) (true / false)");
					player.sendMessage("§a/simplecreator setglowing (name) (true / false)");
					player.sendMessage("§a/simplecreator setgravity (name) (true / false)");
					player.sendMessage("§a/simplecreator setdefaultdrop (name) (true / false)");
					player.sendMessage("§a/simplecreator sethealth (name) (max health)");
					player.sendMessage("§a/simplecreator setdroppedxp (name) (xp)");
					player.sendMessage("§a/simplecreator setfireticks (name) (ticks)");
					player.sendMessage("§a/simplecreator sethelmet (name) (custom item)");
					player.sendMessage("§a/simplecreator setchestplate (name) (custom item)");
					player.sendMessage("§a/simplecreator setleggings (name) (custom item)");
					player.sendMessage("§a/simplecreator setboots (name) (custom item)");
					player.sendMessage("§a/simplecreator setmainhand (name) (custom item)");
					player.sendMessage("§a/simplecreator setoffhand (name) (custom item)");
					player.sendMessage("§a/simplecreator addpotioneffect (name) (potion effect) (duration) (amplifier)");
					player.sendMessage("§a/simplecreator adddrop (name) (custom item)");
					player.sendMessage("§6=========Help=========");
				}
				
				if(args[1].equalsIgnoreCase("item")) 
				{
					player.sendMessage("");
					player.sendMessage("§6=========Items=========");
					player.sendMessage("§a/simplecreator createitem (name)");
					player.sendMessage("§a/simplecreator giveitem (name)");
					player.sendMessage("§a/simplecreator setitemmaterial (name) (material)");
					player.sendMessage("§a/simplecreator setunbreakable (name) (true / false)");
					player.sendMessage("§a/simplecreator setamount (name) (amount)");
					player.sendMessage("§a/simplecreator addenchantment (name) (enchantment) (level)");
					player.sendMessage("§a/simplecreator addflag (name) (flag)");
					player.sendMessage("§6=========Help=========");
				}
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for reload MtxLib
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public void reloadCommand(Player player, String[] args)
	{
		if(player.hasPermission("simplecreator.command.reload") == true || player.isOp())
		{
			player.sendMessage("§cSimpleCreator reloading ...");
			Bukkit.getPluginManager().disablePlugin(this.plugin);
			Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin("SimpleCreator"));
			player.sendMessage("§aSimpleCreator reloaded !");
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
}
