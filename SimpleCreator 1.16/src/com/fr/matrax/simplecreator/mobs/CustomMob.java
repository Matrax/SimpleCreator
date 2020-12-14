package com.fr.matrax.simplecreator.mobs;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * This class represent a custom mob
 * @version 1.0
 * @author _Matrax_
 */
public abstract class CustomMob
{
	
	private String name;
	private boolean loaded;
	
	/**
	 * This method is called when the custom mob spawn
	 * @param location The spawn location of the mob
	 * @return A living entity
	 */
	public abstract LivingEntity OnSpawn(Location location);
	
	/**
	 * This method is called when the custom die
	 * @param event The EntityDeathEvent of bukkit
	 */
	public abstract void OnKill(EntityDeathEvent event);
	
	/**
	 * This method is called when the custom mob is unloaded
	 */
	public abstract void OnUnload();
	
	/**
	 * This method is called when the custom mob is loaded
	 */
	public abstract void OnLoad();
	
	/**
	 * Constructor of the class CustomMob.
	 * This is an abstract class.
	 * @param name The name of the custom mob
	 */
	protected CustomMob(String name) 
	{
		this.name = name;
		this.loaded = false;
	}
	
	/**
	 * This method spawn a custom mob on a location
	 * @param location The location to spawn the mob
	 */
	public LivingEntity spawn(Location location)
	{
		return this.OnSpawn(location);
	}
	
	/**
	 * This method load the custom mob
	 */
	public void load()
	{
		if(this.isLoaded() == false) this.OnLoad();
		this.loaded = true;
	}
	
	/**
	 * This method unload the custom mob
	 */
	public void unload()
	{
		if(this.loaded == true) this.OnUnload();
		this.loaded = false;
	}
	
	/**
	 * This method return the name of the custom mob
	 * @return The name of the custom mob
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * This method check if the custom mob is loaded
	 * @return if the custom mob is loaded
	 */
	public boolean isLoaded() 
	{
		return this.loaded;
	}

}
