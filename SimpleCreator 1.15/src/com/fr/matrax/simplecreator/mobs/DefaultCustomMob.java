package com.fr.matrax.simplecreator.mobs;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;

import com.fr.matrax.simplecreator.files.DefaultCustomMobFile;
import com.fr.matrax.simplecreator.items.DefaultCustomItem;
import com.fr.matrax.simplecreator.managers.CustomMobManager;

public class DefaultCustomMob extends CustomMob 
{
	
	private String displayName;
	private DefaultCustomMobFile customMobFile;
	private DefaultCustomMobEquipment customMobEquipment;
	private CustomEntityList entityList;
	private List<PotionEffect> potionEffects;
	private List<DefaultCustomItem> drops;
	private EntityType entityType;
	private boolean AI;
	private boolean collidable;
	private boolean gliding;
	private boolean glowing;
	private boolean gravity;
	private boolean defaultDrop;
	private int fireTicks;
	private int health;
	private int droppedXp;
	
	/**
	 * Constructor of the class DefaultCustomMob
	 * @param name the name of the custom mob
	 */
	public DefaultCustomMob(String name) 
	{
		super(name);
		this.displayName = name;
		this.entityType = EntityType.PIG;
		this.health = 10;
		this.droppedXp = 1;
		this.defaultDrop = true;
		this.entityList = new CustomEntityList(100);
		this.potionEffects = new ArrayList<PotionEffect>();
		this.drops = new ArrayList<DefaultCustomItem>();
		this.customMobEquipment = new DefaultCustomMobEquipment();
		this.customMobFile = new DefaultCustomMobFile(this);
		this.customMobFile.initialize();
	}
	
	@Override
	public void OnLoad() 
	{
		CustomMobManager.getCustomMobManager().add(this);
	}
	
	@Override
	public void OnUnload() 
	{
		this.entityList.clear(true);
	}
	
	@Override
	public LivingEntity OnSpawn(Location location) 
	{
		World world = location.getWorld();
		LivingEntity entity = (LivingEntity) world.spawnEntity(location, this.entityType);
		this.displayName = ChatColor.translateAlternateColorCodes('&', this.displayName);
		entity.getEquipment().clear();
		if(this.customMobEquipment.getMainHand() != null) entity.getEquipment().setItemInMainHand(this.customMobEquipment.getMainHand().toItemStack());
		if(this.customMobEquipment.getOffHand() != null) entity.getEquipment().setItemInMainHand(this.customMobEquipment.getOffHand().toItemStack());
		if(this.customMobEquipment.getHelmet() != null) entity.getEquipment().setHelmet(this.customMobEquipment.getHelmet().toItemStack());
		if(this.customMobEquipment.getChestplate() != null) entity.getEquipment().setChestplate(this.customMobEquipment.getChestplate().toItemStack());
		if(this.customMobEquipment.getLeggings() != null) entity.getEquipment().setLeggings(this.customMobEquipment.getLeggings().toItemStack());
		if(this.customMobEquipment.getBoots() != null) entity.getEquipment().setBoots(this.customMobEquipment.getBoots().toItemStack());
		entity.getEquipment().setItemInMainHandDropChance(this.customMobEquipment.getMainHandDropChance());
		entity.getEquipment().setItemInOffHandDropChance(this.customMobEquipment.getOffHandDropChance());
		entity.getEquipment().setHelmetDropChance(this.customMobEquipment.getHelmetDropChance());
		entity.getEquipment().setChestplateDropChance(this.customMobEquipment.getChestplateDropChance());
		entity.getEquipment().setLeggingsDropChance(this.customMobEquipment.getLeggingsDropChance());
		entity.getEquipment().setBootsDropChance(this.customMobEquipment.getBootsDropChance());
		entity.setCustomNameVisible(true);
		entity.setCustomName(this.displayName);
		entity.setHealth(this.health);
		entity.setAI(this.AI);
		entity.setCollidable(this.collidable);
		entity.setGliding(this.gliding);
		entity.setGravity(this.gravity);
		entity.setGlowing(this.glowing);
		entity.addPotionEffects(this.potionEffects);
		entity.setFireTicks(this.fireTicks);
		this.entityList.add(entity);
		return entity;
	}
	
	@Override
	public void OnKill(EntityDeathEvent event)
	{
		event.setDroppedExp(this.droppedXp);
		if(this.defaultDrop == false) event.getDrops().clear();
		for(DefaultCustomItem customItem : this.drops)
		{
			event.getDrops().add(customItem.toItemStack());
		}
	}
	
	/**
	 * This method set the display name of the custom mob
	 * @param displayName The display name to set
	 */
	public void setDisplayName(String displayName) 
	{
		this.displayName = displayName;
	}
	
	/**
	 * This method set the list of potion effects of the custom mob
	 * @param potionEffects The list of potion effects to set
	 */
	public void setPotionEffects(List<PotionEffect> potionEffects) 
	{
		this.potionEffects = potionEffects;
	}
	
	/**
	 * This method set the drop list of the custom mob
	 * @param drops The list of custom items
	 */
	public void setDrops(List<DefaultCustomItem> drops) 
	{
		this.drops = drops;
	}
	
	/**
	 * This method set the health of the custom mob
	 * @param health The health of the mob to set
	 */
	public void setHealth(int health) 
	{
		this.health = health;
	}
	
	/**
	 * This method set the dropped experience of the custom mob
	 * @param droppedXp The amount of experience
	 */
	public void setDroppedXp(int droppedXp) 
	{
		this.droppedXp = droppedXp;
	}
	
	/**
	 * This method set active the AI of the custom mob
	 * @param AI Active the AI or not
	 */
	public void setAI(boolean AI) 
	{
		this.AI = AI;
	}
	
	/**
	 * This method set the default drop of the custom mob active or not
	 * @param defaultDrop Active the default drop or not
	 */
	public void setDefaultDrop(boolean defaultDrop) 
	{
		this.defaultDrop = defaultDrop;
	}
	
	/**
	 * This method set the custom mob collidable
	 * @param collidable Active the collision or not
	 */
	public void setCollidable(boolean collidable) 
	{
		this.collidable = collidable;
	}
	
	/**
	 * This method set the custom mob gliding
	 * @param gliding Active gliding for the mob
	 */
	public void setGliding(boolean gliding) 
	{
		this.gliding = gliding;
	}
	
	/**
	 * This method set the custom mob glowing
	 * @param glowing Active glow on a mob or not
	 */
	public void setGlowing(boolean glowing) 
	{
		this.glowing = glowing;
	}
	
	/**
	 * This method set the gravity of the custom mob
	 * @param gravity Active the gravity for a mob or not
	 */
	public void setGravity(boolean gravity) 
	{
		this.gravity = gravity;
	}
	
	/**
	 * This method set the fire ticks of the custom mob
	 * @param fireTicks The number of tick
	 */
	public void setFireTicks(int fireTicks) 
	{
		this.fireTicks = fireTicks;
	}
	
	/**
	 * This method set the entity type of the custom mob
	 * @param entityType The entity type to set
	 */
	public void setEntityType(EntityType entityType) 
	{
		this.entityType = entityType;
	}
	
	/**
	 * This method return the list of potions effects of the custom mob
	 * @return The list of potions effects of the custom mob
	 */
	public List<PotionEffect> getPotionEffects() 
	{
		return potionEffects;
	}
	
	/**
	 * This method return the drops list of the custom mob
	 * @return The drops list of the custom mob
	 */
	public List<DefaultCustomItem> getDrops() 
	{
		return drops;
	}
	
	/**
	 * This method return the entity type of the custom mob
	 * @return The entity type of the custom mob
	 */
	public EntityType getEntityType() 
	{
		return this.entityType;
	}
	
	/**
	 * This method return the display name of the custom mob
	 * @return The display name of the custom mob
	 */
	public String getDisplayName() 
	{
		return this.displayName;
	}
	
	/**
	 * This method return the equipment of the custom mob
	 * @return The equipment of the custom mob
	 */
	public DefaultCustomMobEquipment getCustomMobEquipment() 
	{
		return this.customMobEquipment;
	}
	
	/**
	 * This method return the file configuration of the custom mob
	 * @return The file configuration of the custom mob
	 */
	public DefaultCustomMobFile getCustomMobFile() 
	{
		return this.customMobFile;
	}
	
	/**
	 * This method return the living entity list of the custom mob 
	 * @return The living entity list of the custom mob
	 */
	public CustomEntityList getEntityList() 
	{
		return this.entityList;
	}
	
	/**
	 * This method return the fire ticks of the custom mob
	 * @return The fire ticks of the custom mob
	 */
	public int getFireTicks() 
	{
		return this.fireTicks;
	}
	
	/**
	 * This method return the health of the custom mob
	 * @return The health of the custom mob
	 */
	public int getHealth() 
	{
		return this.health;
	}
	
	/**
	 * This method return the dropped experience of the custom mob
	 */
	public int getDroppedXp() 
	{
		return this.droppedXp;
	}
	
	/**
	 * This method check if the custom mob has an AI
	 * @return If the custom mob has an AI
	 */
	public boolean hasAI() 
	{
		return this.AI;
	}
	
	/**
	 * This method check if the custom mob is collidable
	 * @return If the custom mob is collidable
	 */
	public boolean isCollidable() 
	{
		return this.collidable;
	}
	
	/**
	 * This method check if the custom mob is gliding
	 * @return If the custom mob is gliding
	 */
	public boolean isGliding() 
	{
		return this.gliding;
	}
	
	/**
	 * This method check if the custom mob is glowing
	 * @return If the custom mob is glowing
	 */
	public boolean isGlowing() 
	{
		return this.glowing;
	}
	
	/**
	 * This method check if the custom mob has gravity
	 * @return If the custom mob has gravity
	 */
	public boolean hasGravity() 
	{
		return this.gravity;
	}
	
	/**
	 * This method check if the custom mob can drop his default drop
	 * @return If the custom mob can drop his default drop
	 */
	public boolean canDefaultDrop() 
	{
		return defaultDrop;
	}
	
}
