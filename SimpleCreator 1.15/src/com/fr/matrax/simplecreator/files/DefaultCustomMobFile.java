package com.fr.matrax.simplecreator.files;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.fr.matrax.simplecreator.items.DefaultCustomItem;
import com.fr.matrax.simplecreator.managers.CustomItemManager;
import com.fr.matrax.simplecreator.mobs.DefaultCustomMob;

public class DefaultCustomMobFile extends PluginFile 
{
	
	private DefaultCustomMob defaultCustomMob;
	
	/**
	 * Constructor of the class DefaultCustomMobFile
	 * @param customMob The custom mob
	 */
	public DefaultCustomMobFile(DefaultCustomMob customMob) 
	{
		super("plugins/SimpleCreator/Mobs/" + customMob.getName() + ".yml");
		this.defaultCustomMob = customMob;
	}
	
	@Override
	public void OnCreate() {
		this.set("display_name", this.defaultCustomMob.getDisplayName());
		this.set("entity_type", this.defaultCustomMob.getEntityType().name());
		this.set("health", this.defaultCustomMob.getHealth());
		this.set("AI", this.defaultCustomMob.hasAI());
		this.set("fire_ticks", this.defaultCustomMob.getFireTicks());
		this.set("collidable", this.defaultCustomMob.isCollidable());
		this.set("gliding", this.defaultCustomMob.isGliding());
		this.set("glowing", this.defaultCustomMob.isGlowing());
		this.set("gravity", this.defaultCustomMob.hasGravity());
		this.set("default_drop", this.defaultCustomMob.canDefaultDrop());
		this.set("dropped_xp", this.defaultCustomMob.getDroppedXp());
		this.set("main_hand.item", "");
		this.set("main_hand.drop_chance", this.defaultCustomMob.getCustomMobEquipment().getMainHandDropChance());
		this.set("off_hand.item", "");
		this.set("off_hand.drop_chance", this.defaultCustomMob.getCustomMobEquipment().getOffHandDropChance());
		this.set("helmet.item", "");
		this.set("helmet.drop_chance", this.defaultCustomMob.getCustomMobEquipment().getHelmetDropChance());
		this.set("chestplate.item", "");
		this.set("chestplate.drop_chance", this.defaultCustomMob.getCustomMobEquipment().getChestplateDropChance());
		this.set("leggings.item", "");
		this.set("leggings.drop_chance", this.defaultCustomMob.getCustomMobEquipment().getLeggingsDropChance());
		this.set("boots.item", "");
		this.set("boots.drop_chance", this.defaultCustomMob.getCustomMobEquipment().getBootsDropChance());
		this.set("potion_effects", new ArrayList<String>());
		this.set("drops", new ArrayList<String>());
		this.save();
	}
	
	@Override
	public void OnLoad()
	{
		this.defaultCustomMob.setDisplayName(this.getString("display_name"));
		this.defaultCustomMob.setEntityType(this.getEntityType("entity_type"));
		this.defaultCustomMob.setHealth(this.getInt("health"));
		this.defaultCustomMob.setDroppedXp(this.getInt("dropped_xp"));
		this.defaultCustomMob.setAI(this.getBoolean("AI"));
		this.defaultCustomMob.setFireTicks(this.getInt("fire_ticks"));
		this.defaultCustomMob.setCollidable(this.getBoolean("collidable"));
		this.defaultCustomMob.setGliding(this.getBoolean("gliding"));
		this.defaultCustomMob.setGlowing(this.getBoolean("glowing"));
		this.defaultCustomMob.setGravity(this.getBoolean("gravity"));
		this.defaultCustomMob.setDefaultDrop(this.getBoolean("default_drop"));
		this.loadPotionEffects();
		this.loadEquiments();
		this.loadDrops();
	}
	
	/**
	 * This method load all the potion effects of 
	 * the custom mob from the configuration file
	 */
	public void loadPotionEffects()
	{
		List<PotionEffect> potionEffects = new ArrayList<PotionEffect>();
		List<String> list = this.getStringList("potion_effects");
		
		for(String potionEffect : list)
		{
			String[] potionData = potionEffect.split(":");
			PotionEffectType potionEffectType = PotionEffectType.getByName(potionData[0]);
			int duration = Integer.valueOf(potionData[1]);
			int amplififier = Integer.valueOf(potionData[2]);
			potionEffects.add(new PotionEffect(potionEffectType, duration, amplififier));
		}
		this.defaultCustomMob.setPotionEffects(potionEffects);
	}
	
	/**
	 * This method Load all the equipments of the 
	 * custom mob from the configuration file
	 */
	public void loadEquiments()
	{
		CustomItemManager manager = CustomItemManager.getCustomItemManager();
		DefaultCustomItem mainHandItem = (DefaultCustomItem) manager.getByName(this.getString("main_hand.item"));
		DefaultCustomItem offHandItem = (DefaultCustomItem) manager.getByName(this.getString("off_hand.item"));
		DefaultCustomItem helmetItem = (DefaultCustomItem) manager.getByName(this.getString("helmet.item"));
		DefaultCustomItem chestplateItem = (DefaultCustomItem) manager.getByName(this.getString("chestplate.item"));
		DefaultCustomItem leggingsItem = (DefaultCustomItem) manager.getByName(this.getString("leggings.item"));
		DefaultCustomItem bootsItem = (DefaultCustomItem) manager.getByName(this.getString("boots.item"));
		
		this.defaultCustomMob.getCustomMobEquipment().setMainHandDropChance(this.getFloat("main_hand.drop_chance"));
		this.defaultCustomMob.getCustomMobEquipment().setOffHandDropChance(this.getFloat("off_hand.drop_chance"));
		this.defaultCustomMob.getCustomMobEquipment().setHelmetDropChance(this.getFloat("helmet.drop_chance"));
		this.defaultCustomMob.getCustomMobEquipment().setChestplateDropChance(this.getFloat("chestplate.drop_chance"));
		this.defaultCustomMob.getCustomMobEquipment().setLeggingsDropChance(this.getFloat("leggings.drop_chance"));
		this.defaultCustomMob.getCustomMobEquipment().setBootsDropChance(this.getFloat("boots.drop_chance"));
		
		if(mainHandItem != null) this.defaultCustomMob.getCustomMobEquipment().setMainHand(mainHandItem);
		if(offHandItem != null) this.defaultCustomMob.getCustomMobEquipment().setOffHand(offHandItem);
		if(helmetItem != null) this.defaultCustomMob.getCustomMobEquipment().setHelmet(helmetItem);
		if(chestplateItem != null) this.defaultCustomMob.getCustomMobEquipment().setChestplate(chestplateItem);
		if(leggingsItem != null) this.defaultCustomMob.getCustomMobEquipment().setLeggings(leggingsItem);
		if(bootsItem != null) this.defaultCustomMob.getCustomMobEquipment().setBoots(bootsItem);
	}
	
	/**
	 * This method load all drops of the custom mob from the configuration file
	 */
	public void loadDrops()
	{
		List<DefaultCustomItem> customItems = new ArrayList<DefaultCustomItem>();
		List<String> list = this.getStringList("drops");
		CustomItemManager manager = CustomItemManager.getCustomItemManager();
		
		for(String item : list)
		{
			DefaultCustomItem customItem = (DefaultCustomItem) manager.getByName(item);
			if(customItem != null) customItems.add(customItem);
		}
		
		this.defaultCustomMob.setDrops(customItems);
	}

}
