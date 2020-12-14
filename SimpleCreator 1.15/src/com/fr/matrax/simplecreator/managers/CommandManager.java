package com.fr.matrax.simplecreator.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class represent the command manager of the plugin
 * @version 1.0
 * @author _Matrax_
 */
public class CommandManager implements CommandExecutor 
{
	
	private JavaPlugin plugin;
	
	/**
	 * Constructor of the class CommandManager
	 * @param plugin The instance of the plugin
	 */
	public CommandManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
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
				return true;
			}
			
			if(args[0].equalsIgnoreCase("reload")) this.reloadCommand(player, args);
			return true;
		}
		
		return false;
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
