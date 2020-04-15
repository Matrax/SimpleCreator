package com.fr.matrax.simplecreator.managers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;

import com.fr.matrax.simplecreator.items.CustomItem;
import com.fr.matrax.simplecreator.items.DefaultCustomItem;

public class CustomItemManager {
	
	private static CustomItemManager customItemManager;
	
	private JavaPlugin plugin;
	private List<CustomItem> customItems;
	private int count;
	
	/**
	 * Constructor of the class CustomItemManager
	 * @param plugin The instance of the plugin
	 */
	public CustomItemManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
		this.customItems = new ArrayList<CustomItem>();
		customItemManager = this;
	}
	
	/**
	 * This function return the instance of the custom item manager
	 * @return The instance of the custom item manager
	 */
	public static CustomItemManager getCustomItemManager() {
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
					new DefaultCustomItem(files[i].replace(".yml", "")).load();
					counter++;
				}
			}
		}
		this.plugin.getLogger().info(counter + " custom items loaded !");
	}
	
	/**
	 * this method unload all the custom items on the server
	 */
	public void unload()
	{
		if(this.customItems.size() > 0)
		{
			for(CustomItem customItem : this.customItems)
			{
				if(customItem != null) customItem.unload();
			}
		}
		this.customItems.clear();
	}
	
	
	/**
	 * This method add a new custom item
	 * @param customItem The custom item to add
	 */
	public void add(CustomItem customItem)
	{
		if(this.contains(customItem) == false)
		{
			this.customItems.add(customItem);
			this.count++;
		}
	}
	
	/**
	 * This method remove a custom item
	 * @param customItem the custom item to remove
	 */
	public void remove(CustomItem customItem)
	{
		if(this.contains(customItem) == true)
		{
			this.customItems.remove(customItem);
			this.count--;
		}
	}
	
	/**
	 * This method check if the manager contains a custom item
	 * @param customItem The custom item to check
	 * @return If the manager contains a custom item
	 */
	public boolean contains(CustomItem customItem)
	{
		return this.customItems.contains(customItem);
	}
	
	/**
	 * This method check if the manager contains a custom item with his name
	 * @param name The custom item to check
	 * @return If the manager contains a custom item with his name
	 */
	public boolean contains(String name)
	{
		for(CustomItem customMob : this.customItems)
		{
			if(customMob.getName().equals(name)) return true;
		}
		return false;
	}
	
	/**
	 * This method return a custom item by his name
	 * @param name The name of the custom item
	 * @return The custom item returned by his name
	 */
	public CustomItem getByName(String name)
	{
		for(CustomItem customMob : this.customItems)
		{
			if(customMob.getName().equals(name)) return customMob;
		}
		return null;
	}
	
	/**
	 * This method return the count of item
	 * @return The count of item
	 */
	public int getCount() 
	{
		return count;
	}
	
	/**
	 * This method return the list of the custom items
	 * @return The list of the custom items
	 */
	public List<CustomItem> getCustomItems() 
	{
		return customItems;
	}
	
}
