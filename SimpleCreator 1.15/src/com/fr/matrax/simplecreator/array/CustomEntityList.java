package com.fr.matrax.simplecreator.array;

import org.bukkit.entity.LivingEntity;

/**
 * This class represent a custom living entity list
 * @version
 * @author _Matrax_
 */
public class CustomEntityList extends SimpleList<LivingEntity>
{
	
	/**
	 * Constructor of the class CustomEntityList.
	 * Create a list of living entities.
	 * @param max The max of entity in the list
	 */
	public CustomEntityList(int max)
	{
		super(LivingEntity.class, max);
	}
	
	/**
	 * This method remove a living entity in the list
	 * @param entity The entity to remove
	 */
	public void remove(LivingEntity entity, boolean kill)
	{
		for(int i = 0; i < this.getMax(); i++)
		{
			if(this.get(i) != null && this.get(i) == entity)
			{
				if(kill == true) this.get(i).remove();
				this.set(null, i);
				this.decrementCount();
				break;
			}
		}
	}
	
	/**
	 * This method clear the list of living entity
	 */
	public void clear(boolean kill)
	{
		if(this.getCount() > 0)
		{
			for(int i = 0; i < this.getMax(); i++)
			{
				if(this.get(i) != null && kill == true) this.get(i).remove();
				this.set(null, i);
			}
		}
		this.setCount(0);
	}

}
