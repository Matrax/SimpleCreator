package com.fr.matrax.simplecreator.mobs;

import com.fr.matrax.simplecreator.items.DefaultCustomItem;

public class DefaultCustomMobEquipment {	
	
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
	 * Manager of the equipment of a custom mob
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
	 * Set the boot
	 * @param boots
	 */
	public void setBoots(DefaultCustomItem boots) {
		this.boots = boots;
	}
	
	/**
	 * Set the leggings
	 * @param leggings
	 */
	public void setLeggings(DefaultCustomItem leggings) {
		this.leggings = leggings;
	}
	
	/**
	 * Set the chestplate
	 * @param chestplate
	 */
	public void setChestplate(DefaultCustomItem chestplate) {
		this.chestplate = chestplate;
	}
	
	/**
	 * Set the helmet
	 * @param helmet
	 */
	public void setHelmet(DefaultCustomItem helmet) {
		this.helmet = helmet;
	}
	
	/**
	 * Set the main hand
	 * @param mainHand
	 */
	public void setMainHand(DefaultCustomItem mainHand) {
		this.mainHand = mainHand;
	}
	
	/**
	 * Set the off hand
	 * @param offHand
	 */
	public void setOffHand(DefaultCustomItem offHand) {
		this.offHand = offHand;
	}
	
	/**
	 * Set the boots drop chance
	 * @param bootsDropChance
	 */
	public void setBootsDropChance(float bootsDropChance) {
		this.bootsDropChance = bootsDropChance;
	}
	
	/**
	 * Set the chestplate drop chance
	 * @param chestplateDropChance
	 */
	public void setChestplateDropChance(float chestplateDropChance) {
		this.chestplateDropChance = chestplateDropChance;
	}
	
	/**
	 * Set the helmet drop chance
	 * @param helmetDropChance
	 */
	public void setHelmetDropChance(float helmetDropChance) {
		this.helmetDropChance = helmetDropChance;
	}
	
	/**
	 * Set the leggings drop chance
	 * @param leggingsDropChance
	 */
	public void setLeggingsDropChance(float leggingsDropChance) {
		this.leggingsDropChance = leggingsDropChance;
	}
	
	/**
	 * Set the main hand drop chance
	 * @param mainHandDropChance
	 */
	public void setMainHandDropChance(float mainHandDropChance) {
		this.mainHandDropChance = mainHandDropChance;
	}
	
	/**
	 * Set the off hand drop chance
	 * @param offHandDropChance
	 */
	public void setOffHandDropChance(float offHandDropChance) {
		this.offHandDropChance = offHandDropChance;
	}
	
	/**
	 * Get the boots
	 * @return
	 */
	public DefaultCustomItem getBoots() {
		return boots;
	}
	
	/**
	 * Get the chestplate
	 * @return
	 */
	public DefaultCustomItem getChestplate() {
		return chestplate;
	}
	
	/**
	 * Get the helmet
	 * @return
	 */
	public DefaultCustomItem getHelmet() {
		return helmet;
	}
	
	/**
	 * Get the leggings
	 * @return
	 */
	public DefaultCustomItem getLeggings() {
		return leggings;
	}
	
	/**
	 * Get the main hand
	 * @return
	 */
	public DefaultCustomItem getMainHand() {
		return mainHand;
	}
	
	/**
	 * Get the off hand
	 * @return
	 */
	public DefaultCustomItem getOffHand() {
		return offHand;
	}
	
	/**
	 * Get the boot drop chance
	 * @return
	 */
	public float getBootsDropChance() {
		return bootsDropChance;
	}
	
	/**
	 * Get the chestplate drop chance
	 * @return
	 */
	public float getChestplateDropChance() {
		return chestplateDropChance;
	}
	
	/**
	 * Get the helmet drop chance
	 * @return
	 */
	public float getHelmetDropChance() {
		return helmetDropChance;
	}
	
	/**
	 * Get the leggings drop chance
	 * @return
	 */
	public float getLeggingsDropChance() {
		return leggingsDropChance;
	}
	
	/**
	 * Get the main hand drop chance
	 * @return
	 */
	public float getMainHandDropChance() {
		return mainHandDropChance;
	}
	
	/**
	 * Get the off hand drop chance
	 * @return
	 */
	public float getOffHandDropChance() {
		return offHandDropChance;
	}

}
