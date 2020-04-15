package com.fr.matrax.simplecreator.managers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;

import com.fr.matrax.simplecreator.mobs.CustomMob;
import com.fr.matrax.simplecreator.mobs.DefaultCustomMob;

public class CustomMobManager 
{
	
	private static CustomMobManager customMobManager;
	
	private JavaPlugin plugin;
	private List<CustomMob> customMobs;
	private int count;
	
	/**
	 * Constructor of the class CustomMobManager
	 * @param plugin The instance of the plugin
	 */
	public CustomMobManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
		this.customMobs = new ArrayList<CustomMob>();
		customMobManager = this;
	}
	
	/**
	 * This function return the instance of the custom mob manager
	 * @return The instance of the custom mob manager
	 */
	public static CustomMobManager getCustomMobManager() 
	{
		return customMobManager;
	}
	
	/**
	 * This method load all custom mobs inside a directory from configuration files
	 * @param itemDirectory The mob directory of the configuration file
	 */
	public void load(String mobDirectory)
	{
		int counter = 0;
		File directory = new File(mobDirectory);
		if(directory.exists() == false) directory.mkdir();
		String[] files = directory.list();
		
		if(files != null && files.length > 0) 
		{
			for(int i = 0; i < files.length; i++)
			{
				if(files[i] != null)
				{
					new DefaultCustomMob(files[i].replace(".yml", "")).load();
					counter++;
				}
			}
		}
		this.plugin.getLogger().info(counter + " custom mobs loaded !");
	}
	
	/**
	 * this method unload all the custom mobs on the server
	 */
	public void unload()
	{
		for(CustomMob customMob : this.customMobs)
		{
			customMob.unload();
		}
		this.customMobs.clear();
	}
	
	/**
	 * This method add a new custom mob
	 * @param customItem the custom mob to add
	 */
	public void add(CustomMob customMob)
	{
		if(this.contains(customMob) == false)
		{
			this.customMobs.add(customMob);
			this.count++;
		}
	}
	
	/**
	 * This method remove a custom mob
	 * @param customItem The custom mob to remove
	 */
	public void remove(CustomMob customMob)
	{
		if(this.contains(customMob) == true)
		{
			this.customMobs.remove(customMob);
			this.count--;
		}
	}
	
	/**
	 * This method check if the manager contains a custom mob
	 * @param customItem The custom mob to check
	 * @return If the manager contains a custom mob
	 */
	public boolean contains(CustomMob customMob)
	{
		return this.customMobs.contains(customMob);
	}
	
	/**
	 * This method check if the manager contains a custom mob with his name
	 * @param customItem The custom mob to check
	 * @return If the manager contains a custom mob with his name
	 */
	public boolean contains(String name)
	{
		for(CustomMob customMob : this.customMobs)
		{
			if(customMob.getName().equals(name)) return true;
		}
		return false;
	}
	
	/**
	 * This method return a custom mob by his name
	 * @param name The name of the custom mob
	 * @return The custom mob returned by his name
	 */
	public CustomMob getByName(String name)
	{
		for(CustomMob customMob : this.customMobs)
		{
			if(customMob.getName().equals(name)) return customMob;
		}
		return null;
	}
	
	/**
	 * This method return the count of custom entities alive on the server
	 * @return The count of custom entities alive on the server
	 */
	public int getCountCustomEntityAlive()
	{
		int count = 0;
		for(CustomMob customMob : this.customMobs)
		{
			if(customMob instanceof DefaultCustomMob)
			{
				DefaultCustomMob mob = (DefaultCustomMob) customMob;
				count += mob.getEntityList().getCount();
			}
		}
		return count;
	}
	
	/**
	 * This method return the count of custom mob loaded
	 * @return The count of custom mob loaded
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * This method return the custom mobs list
	 * @return The custom mobs list
	 */
	public List<CustomMob> getCustomMobs() {
		return customMobs;
	}

}
