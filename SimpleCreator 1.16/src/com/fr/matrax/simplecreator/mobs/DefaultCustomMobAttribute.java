package com.fr.matrax.simplecreator.mobs;

import org.bukkit.attribute.Attribute;

/**
 * This class represent an attribute and the value for a custom mob
 * @version 1.0
 * @author _Matrax_
 */
public class DefaultCustomMobAttribute 
{
	
	private Attribute attribute;
	private double value;
	
	/**
	 * Constructor of the class DefaultCustomMobAttribute
	 * @param attribute The attribute
	 * @param value The value
	 */
	public DefaultCustomMobAttribute(Attribute attribute, double value)
	{
		this.attribute = attribute;
		this.value = value;
	}
	
	/**
	 * This method return the attribute
	 * @return The attribute
	 */
	public Attribute getAttribute() 
	{
		return this.attribute;
	}
	
	/**
	 * This method return the value of the attribute
	 * @return The value of the attribute
	 */
	public double getValue() 
	{
		return this.value;
	}

}
