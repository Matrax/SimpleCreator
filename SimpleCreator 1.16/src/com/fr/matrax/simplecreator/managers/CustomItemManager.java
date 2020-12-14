package com.fr.matrax.simplecreator.managers;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import com.fr.matrax.simplecreator.array.CustomItemList;
import com.fr.matrax.simplecreator.items.DefaultCustomItem;

/**
 * This class represent the custom item manager
 * @version 1.0
 * @author _Matrax_
 */
public class CustomItemManager 
{
	
	private static CustomItemManager customItemManager;
	
	private JavaPlugin plugin;
	private CustomItemList customItemList;
	
	/**
	 * Constructor of the class CustomItemManager
	 * @param plugin The instance of the plugin
	 */
	public CustomItemManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
		this.customItemList = new CustomItemList(100);
		customItemManager = this;
	}
	
	/**
	 * This function return the instance of the custom item manager
	 * @return The instance of the custom item manager
	 */
	public static CustomItemManager getCustomItemManager() 
	{
		return customItemManager;
	}
	
	/**
	 * This method load all custom items inside a directory from configuration files
	 * @param itemDirectory the file directory of the configuration file
	 */
	public void load(String itemDirectory)
	{
		int counter = 0;
		File directory = new File(itemDirectory);
		if(directory.exists() == false) directory.mkdir();
		String[] files = directory.list();
		
		if(files != null && files.length > 0) 
		{
			for(int i = 0; i < files.length; i++)
			{
				if(files[i] != null)
				{
					DefaultCustomItem item = new DefaultCustomItem(files[i].replace(".yml", ""));
					item.load();
					counter++;
				}
			}
		}
		this.plugin.getLogger().info(counter + " custom items loaded !");
	}
	
	/**
	 * This method unload the custom item manager
	 */
	public void unload()
	{
		this.customItemList.unload();
	}
	
	/**
	 * This method return the custom item list
	 * @return The custom item list
	 */
	public CustomItemList getCustomItemList() 
	{
		return this.customItemList;
	}
	
}
