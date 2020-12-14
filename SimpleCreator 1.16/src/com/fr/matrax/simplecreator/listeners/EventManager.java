package com.fr.matrax.simplecreator.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class represent the event manager of the plugin
 * @version 1.0
 * @author _Matrax_
 */
public class EventManager 
{

	private JavaPlugin plugin;
	private PluginManager pluginManager;
	private boolean loaded;
	
	/**
	 * Constructor of the class EventManager
	 * @param plugin The instance of the plugin
	 */
	public EventManager(JavaPlugin plugin)
	{
		this.plugin = plugin;
		this.pluginManager = Bukkit.getPluginManager();
	}
	
	/**
	 * This method load all the event to listen on the server
	 */
	public void load()
	{
		this.pluginManager.registerEvents(new CustomMobListener(), this.plugin);
		this.loaded = true;
	}
	
	/**
	 * This method unload all the event
	 */
	public void unload()
	{
		this.loaded = false;
	}
	
	/**
	 * This method return the instance of the plugin
	 * @return
	 */
	public JavaPlugin getPlugin() 
	{
		return this.plugin;
	}
	
	/**
	 * This method check if the event manager is loaded
	 * @return If the event manager is loaded
	 */
	public boolean isLoaded() 
	{
		return this.loaded;
	}
	
}
