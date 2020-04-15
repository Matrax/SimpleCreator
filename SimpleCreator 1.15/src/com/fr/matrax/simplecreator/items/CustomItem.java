package com.fr.matrax.simplecreator.items;

import org.bukkit.inventory.Inventory;

public abstract class CustomItem
{
	
	private String name;
	private boolean loaded;
	
	public abstract void OnLoad();
	public abstract void OnUnload();
	public abstract void OnGive(Inventory inventory);
	
	/**
	 * Constructor of the class CustomItem
	 * @param name The name of the custom item
	 */
	protected CustomItem(String name) 
	{
		this.name = name;
		this.loaded = false;
	}
	
	/**
	 * This method give the custom item in an inventory
	 * @param inventory The inventory to give the item
	 */
	public void give(Inventory inventory)
	{
		this.OnGive(inventory);
	}
	
	/**
	 * This method load the custom item
	 */
	public void load()
	{
		if(this.loaded == false) this.OnLoad();
		this.loaded = true;
	}
	
	/**
	 * This method unload the custom item
	 */
	public void unload()
	{
		if(this.loaded == true) this.OnUnload();
		this.loaded = false;
	}
	
	/**
	 * This method get the name of the custom item
	 * @return The name of the custom item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method check if the custom item is loaded
	 * @return If the custom item is loaded
	 */
	public boolean isLoaded() {
		return loaded;
	}

}
