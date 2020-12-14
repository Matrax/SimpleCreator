package com.fr.matrax.simplecreator.array;

import com.fr.matrax.simplecreator.items.CustomItem;

/**
 * This class represent a custom item list
 * @version
 * @author _Matrax_
 */
public class CustomItemList extends SimpleList<CustomItem>
{
	
	/**
	 * Constructor of the class CustomItemList
	 * @param max The max of items in the list
	 */
	public CustomItemList(int max)
	{
		super(CustomItem.class, max);
	}
	
	/**
	 * this method unload all the custom items in the list and remove them
	 */
	public void unload()
	{
		for(int i = 0; i < this.getMax(); i++)
		{
			if(this.get(i) != null)
			{
				this.get(i).unload();
				this.set(null, i);
			}
		}
	}
	
	/**
	 * This method check if the manager contains a custom item with his name
	 * @param customItem The custom mob to check
	 * @return If the manager contains a custom item with his name
	 */
	public boolean contains(String name)
	{
		boolean result = false;
		for(int i = 0; i < this.getMax(); i++)
		{
			if(this.get(i) != null && this.get(i).getName().equals(name))
			{
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * This method return a custom item by his name
	 * @param name The name of the custom item
	 * @return The custom item returned by his name
	 */
	public CustomItem getByName(String name)
	{
		CustomItem result = null;
		for(int i = 0; i < this.getMax(); i++)
		{
			if(this.get(i) != null && this.get(i).getName().equals(name))
			{
				result = this.get(i);
				break;
			}
		}
		return result;
	}
}
