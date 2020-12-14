package com.fr.matrax.simplecreator.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

import com.fr.matrax.simplecreator.items.DefaultCustomItem;
import com.fr.matrax.simplecreator.utils.PluginFile;

public class DefaultCustomItemFile extends PluginFile
{
	
	private DefaultCustomItem defaultCustomItem;
	
	/**
	 * Constructor of the class DefaultCustomItemFile.
	 * @param customItem The default custom item
	 */
	public DefaultCustomItemFile(DefaultCustomItem customItem) 
	{
		super("plugins/SimpleCreator/Items/" + customItem.getName() + ".yml");
		this.defaultCustomItem = customItem;
		this.initialize();
	}
	
	@Override
	public void OnCreate() 
	{
		this.set("display_name", this.defaultCustomItem.getDisplayName());
		this.set("material", this.defaultCustomItem.getMaterial().name());
		this.set("amount", this.defaultCustomItem.getAmount());
		this.set("unbreakable", this.defaultCustomItem.isUnbreakable());
		this.set("lore", this.defaultCustomItem.getLore());
		this.set("enchantments", new ArrayList<String>());
		this.set("flags", new ArrayList<String>());
		this.save();
	}
	
	@Override
	public void OnLoad() 
	{
		this.defaultCustomItem.setDisplayName(this.getString("display_name"));
		this.defaultCustomItem.setMaterial(this.getMaterial("material"));
		this.defaultCustomItem.setAmount(this.getInt("amount"));
		this.defaultCustomItem.setUnbreakable(this.getBoolean("unbreakable"));
		this.defaultCustomItem.setLore(this.getStringList("lore"));
		this.loadEnchantments();
		this.loadFlags();
	}
	
	/**
	 * This method load all the enchantments of the 
	 * custom item from the configuration file
	 */
	@SuppressWarnings("deprecation")
	public void loadEnchantments()
	{
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		List<String> list = this.getStringList("enchantments");
		
		for(String enchant : list)
		{
			String[] split = enchant.split(":");
			enchantments.put(Enchantment.getByName(split[0]), Integer.valueOf(split[1]));
		}
		this.defaultCustomItem.setEnchantments(enchantments);
	}
	
	/**
	 * This method load all the flags of the 
	 * custom item from the configuration file
	 */
	public void loadFlags()
	{
		List<String> flags = this.getStringList("flags");
		List<ItemFlag> itemFlags = new ArrayList<ItemFlag>();
		
		for(String flag : flags)
		{
			itemFlags.add(ItemFlag.valueOf(flag));
		}
		this.defaultCustomItem.setFlags(itemFlags);
	}
	
	/**
	 * This method return the custom item of the file
	 * @return The custom item of the file
	 */
	public DefaultCustomItem getDefaultCustomItem() 
	{
		return defaultCustomItem;
	}

}
