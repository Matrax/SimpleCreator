package com.fr.matrax.simplecreator;

import org.bukkit.plugin.java.JavaPlugin;
import com.fr.matrax.simplecreator.listeners.EventManager;
import com.fr.matrax.simplecreator.managers.CommandManager;
import com.fr.matrax.simplecreator.managers.CustomItemManager;
import com.fr.matrax.simplecreator.managers.CustomMobManager;

/**
 * Main class of the plugin SimpleCreator
 * @version 1.0
 * @author _Matrax_
 */
public class Main extends JavaPlugin 
{
	
	private EventManager eventManager;
	private CommandManager commandManager;
	private CustomItemManager customItemManager;
	private CustomMobManager customMobManager;
	
	@Override
	public void onEnable() 
	{
		this.commandManager = new CommandManager(this);
		this.eventManager = new EventManager(this);
		this.customItemManager = new CustomItemManager(this);
		this.customMobManager = new CustomMobManager(this);
		
		this.commandManager.load();
		this.eventManager.load();
		this.customItemManager.load("plugins/SimpleCreator/Items");
		this.customMobManager.load("plugins/SimpleCreator/Mobs");
	}
	
	@Override
	public void onDisable() 
	{
		this.commandManager.unload();
		this.customMobManager.unload();
		this.customItemManager.unload();
	}

}
