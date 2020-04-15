package com.fr.matrax.simplecreator;

import org.bukkit.plugin.java.JavaPlugin;

import com.fr.matrax.simplecreator.commands.CommandManager;
import com.fr.matrax.simplecreator.listeners.EventManager;
import com.fr.matrax.simplecreator.managers.CustomItemManager;
import com.fr.matrax.simplecreator.managers.CustomMobManager;

public class Main extends JavaPlugin 
{
	
	private static EventManager eventManager;
	
	private static CommandManager commandManager;
	private static CustomItemManager customItemManager;
	private static CustomMobManager customMobManager;
	
	@Override
	public void onEnable() 
	{
		commandManager = new CommandManager(this);
		eventManager = new EventManager(this);
		customItemManager = new CustomItemManager(this);
		customMobManager = new CustomMobManager(this);
		
		commandManager.load();
		eventManager.load();
		customItemManager.load("plugins/SimpleCreator/Items");
		customMobManager.load("plugins/SimpleCreator/Mobs");
	}
	
	@Override
	public void onDisable() 
	{
		commandManager.unload();
		customMobManager.unload();
		customItemManager.unload();
	}

}
