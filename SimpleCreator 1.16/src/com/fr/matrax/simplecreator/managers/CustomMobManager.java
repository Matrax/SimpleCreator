package com.fr.matrax.simplecreator.managers;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import com.fr.matrax.simplecreator.array.CustomMobList;
import com.fr.matrax.simplecreator.mobs.DefaultCustomMob;

/**
 * This class represent the custom mob manager
 * @version 1.0
 * @author _Matrax_
 */
public class CustomMobManager 
{
	
	private static CustomMobManager customMobManager;
	
	private JavaPlugin plugin;
	private CustomMobList customMobList;
	
	/**
	 * Constructor of the class CustomMobManager
	 * @param plugin The instance of the plugin
	 */
	public CustomMobManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
		this.customMobList = new CustomMobList(100);
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
	 * This method unload the custom mob list
	 */
	public void unload()
	{
		this.customMobList.unload();
	}
	
	/**
	 * This method return the custom mob list
	 * @return The custom mob list
	 */
	public CustomMobList getCustomMobList() 
	{
		return this.customMobList;
	}

}
