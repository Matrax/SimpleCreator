package com.fr.matrax.simplecreator.mobs;

import org.bukkit.entity.LivingEntity;

public class CustomEntityList 
{
	
	private LivingEntity[] livingEntities;
	private int max;
	private int count;
	
	/**
	 * Constructor of the class CustomEntityList.
	 * Create a list of living entities.
	 * @param max The max of entity in the list
	 */
	public CustomEntityList(int max)
	{
		this.livingEntities = new LivingEntity[max];
		this.max = max;
		this.count = 0;
	}
	
	/**
	 * This method add a living entity in the list
	 * @param entity The entity to add
	 */
	public void add(LivingEntity entity)
	{
		if(this.count < this.max)
		{
			for(int i = 0; i < this.livingEntities.length; i++)
			{
				if(this.livingEntities[i] == null)
				{
					this.livingEntities[i] = entity;
					this.count++;
					break;
				}
			}
		}
	}
	
	/**
	 * This method remove a living entity in the list
	 * @param entity The entity to remove
	 */
	public void remove(LivingEntity entity, boolean kill)
	{
		for(int i = 0; i < this.livingEntities.length; i++)
		{
			if(this.livingEntities[i] != null && this.livingEntities[i] == entity)
			{
				if(kill == true) this.livingEntities[i].remove();
				this.livingEntities[i] = null;
				this.count--;
				break;
			}
		}
	}
	
	/**
	 * This method clear the list of living entity
	 */
	public void clear(boolean kill)
	{
		if(this.count > 0)
		{
			for(int i = 0; i < this.livingEntities.length; i++)
			{
				if(this.livingEntities[i] != null && kill == true) this.livingEntities[i].remove();
				this.livingEntities[i] = null;
			}
		}
		this.count = 0;
	}
	
	/**
	 * This method check if the entity is in the list
	 * @param entity The entity to check
	 * @return if the entity is in the list
	 */
	public boolean contains(LivingEntity entity)
	{
		for(int i = 0; i < this.livingEntities.length; i++)
		{
			if(this.livingEntities[i] != null && this.livingEntities[i] == entity) return true;
		}
		return false;
	}
	
	/**
	 * This method return the count of entities in the list
	 * @return The count of entities in the list
	 */
	public int getCount() 
	{
		return count;
	}
	
	/**
	 * This method return the max of entities in the list
	 * @return The max of entities in the list
	 */
	public int getMax() 
	{
		return max;
	}
	
	/**
	 * This method return the array of entities
	 * @return The array of entities
	 */
	public LivingEntity[] getLivingEntities() 
	{
		return livingEntities;
	}

}
