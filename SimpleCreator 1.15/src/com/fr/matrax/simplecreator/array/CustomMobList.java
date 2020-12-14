package com.fr.matrax.simplecreator.array;

import com.fr.matrax.simplecreator.mobs.CustomMob;
import com.fr.matrax.simplecreator.mobs.DefaultCustomMob;

/**
 * This class represent a custom mob list
 * @version
 * @author _Matrax_
 */
public class CustomMobList extends SimpleList<CustomMob> 
{
	
	/**
	 * Constructor of the class CustomMobList
	 * @param max The max of custom mob in the list
	 */
	public CustomMobList(int max) 
	{
		super(CustomMob.class, max);
	}

	/**
	 * this method unload all the custom mobs in the list and remove them
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
	 * This method check if the manager contains a custom mob with his name
	 * @param customItem The custom mob to check
	 * @return If the manager contains a custom mob with his name
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
	 * This method return a custom mob by his name
	 * @param name The name of the custom mob
	 * @return The custom mob returned by his name
	 */
	public CustomMob getByName(String name)
	{
		CustomMob result = null;
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
	
	/**
	 * This method return the count of custom entities alive on the server
	 * @return The count of custom entities alive on the server
	 */
	public int getCountEntityAlive()
	{
		int count = 0;
		for(int i = 0; i < this.getMax(); i++)
		{
			if(this.get(i) != null && this.get(i) instanceof DefaultCustomMob)
			{
				DefaultCustomMob mob = (DefaultCustomMob) this.get(i);
				count += mob.getEntityList().getCount();
			}
		}
		return count;
	}
	
}
