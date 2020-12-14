package com.fr.matrax.simplecreator.mobs;

import com.fr.matrax.simplecreator.items.DefaultCustomItem;

/**
 * This class represent the equipment of a custom mob
 * @version 1.0
 * @author _Matrax_
 *
 */
public class DefaultCustomMobEquipment 
{	
	
	private DefaultCustomItem mainHand;
	private DefaultCustomItem offHand;
	private DefaultCustomItem helmet;
	private DefaultCustomItem chestplate;
	private DefaultCustomItem leggings;
	private DefaultCustomItem boots;
	private float mainHandDropChance;
	private float offHandDropChance;
	private float helmetDropChance;
	private float chestplateDropChance;
	private float leggingsDropChance;
	private float bootsDropChance;
	
	/**
	 * Constructor of the class DefaultCustomMobEquipment
	 */
	public DefaultCustomMobEquipment() 
	{
		this.mainHandDropChance = 1f;
		this.offHandDropChance = 1f;
		this.helmetDropChance = 1f;
		this.chestplateDropChance = 1f;
		this.leggingsDropChance = 1f;
		this.bootsDropChance = 1f;
		this.mainHand = null;
		this.offHand = null;
		this.helmet = null;
		this.chestplate = null;
		this.leggings = null;
		this.boots = null;
	}
	
	/**
	 * This method set the boots
	 * @param boots The boots to equip
	 */
	public void setBoots(DefaultCustomItem boots) 
	{
		this.boots = boots;
	}
	
	/**
	 * This method set the leggings
	 * @param leggings The leggings to equip
	 */
	public void setLeggings(DefaultCustomItem leggings) 
	{
		this.leggings = leggings;
	}
	
	/**
	 * This method set the chestplate
	 * @param chestplate The chestplate to equip
	 */
	public void setChestplate(DefaultCustomItem chestplate) 
	{
		this.chestplate = chestplate;
	}
	
	/**
	 * This method set the helmet
	 * @param helmet The helmet to equip
	 */
	public void setHelmet(DefaultCustomItem helmet) 
	{
		this.helmet = helmet;
	}
	
	/**
	 * This method set the main hand
	 * @param mainHand The item to equip
	 */
	public void setMainHand(DefaultCustomItem mainHand) 
	{
		this.mainHand = mainHand;
	}
	
	/**
	 * This method set the off hand
	 * @param offHand The item to equip
	 */
	public void setOffHand(DefaultCustomItem offHand) 
	{
		this.offHand = offHand;
	}
	
	/**
	 * This method set the boots drop chance
	 * @param bootsDropChance The drop chance
	 */
	public void setBootsDropChance(float bootsDropChance) {
		this.bootsDropChance = bootsDropChance;
	}
	
	/**
	 * This method set the chestplate drop chance
	 * @param chestplateDropChance The drop chance
	 */
	public void setChestplateDropChance(float chestplateDropChance) {
		this.chestplateDropChance = chestplateDropChance;
	}
	
	/**
	 * This method set the helmet drop chance
	 * @param helmetDropChance The drop chance
	 */
	public void setHelmetDropChance(float helmetDropChance) 
	{
		this.helmetDropChance = helmetDropChance;
	}
	
	/**
	 * This method set the leggings drop chance
	 * @param leggingsDropChance The drop chance
	 */
	public void setLeggingsDropChance(float leggingsDropChance) 
	{
		this.leggingsDropChance = leggingsDropChance;
	}
	
	/**
	 * This method set the main hand drop chance
	 * @param mainHandDropChance The drop chance
	 */
	public void setMainHandDropChance(float mainHandDropChance) 
	{
		this.mainHandDropChance = mainHandDropChance;
	}
	
	/**
	 * This method set the off hand drop chance
	 * @param offHandDropChance The drop chance
	 */
	public void setOffHandDropChance(float offHandDropChance) 
	{
		this.offHandDropChance = offHandDropChance;
	}
	
	/**
	 * This method set the boots
	 * @return The boots
	 */
	public DefaultCustomItem getBoots() 
	{
		return this.boots;
	}
	
	/**
	 * This method get the chestplate
	 * @return The chestplate
	 */
	public DefaultCustomItem getChestplate() 
	{
		return this.chestplate;
	}
	
	/**
	 * This method get the helmet
	 * @return The helmet
	 */
	public DefaultCustomItem getHelmet() 
	{
		return this.helmet;
	}
	
	/**
	 * This method get the leggings
	 * @return The leggings
	 */
	public DefaultCustomItem getLeggings() 
	{
		return this.leggings;
	}
	
	/**
	 * This method get the main hand
	 * @return The main hand item
	 */
	public DefaultCustomItem getMainHand() 
	{
		return this.mainHand;
	}
	
	/**
	 * This method get the off hand
	 * @return The off hand item
	 */
	public DefaultCustomItem getOffHand() 
	{
		return this.offHand;
	}
	
	/**
	 * This method get the boot drop chance
	 * @return The drop chance
	 */
	public float getBootsDropChance() 
	{
		return this.bootsDropChance;
	}
	
	/**
	 * This method get the chestplate drop chance
	 * @return The drop chance
	 */
	public float getChestplateDropChance() 
	{
		return this.chestplateDropChance;
	}
	
	/**
	 * This method get the helmet drop chance
	 * @return The drop chance
	 */
	public float getHelmetDropChance() 
	{
		return this.helmetDropChance;
	}
	
	/**
	 * This method get the leggings drop chance
	 * @return The drop chance
	 */
	public float getLeggingsDropChance() 
	{
		return this.leggingsDropChance;
	}
	
	/**
	 * This method get the main hand drop chance
	 * @return The drop chance
	 */
	public float getMainHandDropChance() 
	{
		return this.mainHandDropChance;
	}
	
	/**
	 * This method get the off hand drop chance
	 * @return The drop chance
	 */
	public float getOffHandDropChance() 
	{
		return this.offHandDropChance;
	}

}
