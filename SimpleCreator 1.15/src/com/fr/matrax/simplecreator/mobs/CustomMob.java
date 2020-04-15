package com.fr.matrax.simplecreator.mobs;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;

public abstract class CustomMob
{
	
	private String name;
	private boolean loaded;
	
	public abstract LivingEntity OnSpawn(Location location);
	public abstract void OnKill(EntityDeathEvent event);
	public abstract void OnUnload();
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
	 * @return The name  
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * This method check if the custom mob is loaded
	 * @return
	 */
	public boolean isLoaded() 
	{
		return loaded;
	}

}
