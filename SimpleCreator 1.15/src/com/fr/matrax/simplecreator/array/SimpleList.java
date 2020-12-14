package com.fr.matrax.simplecreator.array;

import java.lang.reflect.Array;

/**
 * This class represent an array in the plugin
 * @version 1.0
 * @author _Matrax_
 * @param <T> The type of all objects in the array
 */
public abstract class SimpleList<T> implements ISimpleList<T>
{
	
	private T[] array;
	private int max;
	private int count;
	
	/**
	 * Constructor of the class SimpleList.
	 * Create a list of <T>.
	 * @param max The max of <T> in the list
	 */
	@SuppressWarnings("unchecked")
	public SimpleList(Class<T> type, int max)
	{
		this.array = (T[]) Array.newInstance(type, max);
		this.max = max;
		this.count = 0;
	}
	
	/**
	 * This method set an <T> in the array with the index
	 * @param object The <T>
	 * @param i The index of the object
	 */
	public void set(T object, int i)
	{
		this.array[i] = object;
	}
	
	/**
	 * This method return an object from the array with index
	 * @param i The index of the object
	 * @return The <T>
	 */
	public T get(int i)
	{
		return this.array[i];
	}
	
	/**
	 * This method add a <T> in the list
	 * @param entity The <T> to add
	 */
	public void add(T object)
	{
		if(this.count < this.max)
		{
			for(int i = 0; i < this.array.length; i++)
			{
				if(this.array[i] == null)
				{
					this.array[i] = object;
					this.count++;
					break;
				}
			}
		}
	}
	
	/**
	 * This method remove a <T> in the list
	 * @param entity The <T> to remove
	 */
	public void remove(T object)
	{
		for(int i = 0; i < this.array.length; i++)
		{
			if(this.array[i] != null && this.array[i] == object)
			{
				this.array[i] = null;
				this.count--;
				break;
			}
		}
	}
	
	/**
	 * This method clear the list of <T>
	 */
	public void clear()
	{
		if(this.count > 0)
		{
			for(int i = 0; i < this.array.length; i++)
			{
				this.array[i] = null;
			}
		}
		this.count = 0;
	}
	
	/**
	 * This method check if the <T> is in the list
	 * @param object The <T> to check
	 * @return if the <T> is in the list
	 */
	public boolean contains(T object)
	{
		for(int i = 0; i < this.array.length; i++)
		{
			if(this.array[i] != null && this.array[i] == object) return true;
		}
		return false;
	}
	
	/**
	 * This method increment the counter
	 */
	public void incrementCount()
	{
		this.count--;
	}
	
	/**
	 * This method decrement the counter
	 */
	public void decrementCount()
	{
		this.count--;
	}
	
	/**
	 * This method set the count of <T>
	 * @param count The count to set
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
	
	/**
	 * This method return the count of <T> in the list
	 * @return The count of <T> in the list
	 */
	public int getCount() 
	{
		return this.count;
	}
	
	/**
	 * This method return the max of <T> in the list
	 * @return The max of <T> in the list
	 */
	public int getMax() 
	{
		return this.max;
	}
	
	/**
	 * This method return the array of <T>
	 * @return The array of <T>
	 */
	public T[] getArray() 
	{
		return this.array;
	}

}
