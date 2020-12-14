package com.fr.matrax.simplecreator.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.fr.matrax.simplecreator.files.DefaultCustomItemFile;
import com.fr.matrax.simplecreator.managers.CustomItemManager;

/**
 * This class represent a default custom item of the plugin
 * @version 1.0
 * @author _Matrax_
 */
public class DefaultCustomItem extends CustomItem
{
	
	private String displayName;
	private DefaultCustomItemFile customItemFile;
	private List<String> lore;
	private List<ItemFlag> flags;
	private Map<Enchantment, Integer> enchantments;
	private Material material;
	private boolean unbreakable;
	private int amount;
	
	/**
	 * Constructor of the class DefaultCustomItem
	 * @param name The name of the default custom item
	 */
	public DefaultCustomItem(String name) 
	{
		super(name);
		this.displayName = name;
		this.material = Material.WOODEN_PICKAXE;
		this.lore = new ArrayList<String>();
		this.flags = new ArrayList<ItemFlag>();
		this.enchantments = new HashMap<Enchantment, Integer>();
		this.unbreakable = true;
		this.amount = 1;
		this.customItemFile = new DefaultCustomItemFile(this);
		this.customItemFile.initialize();
	}
	
	@Override
	public void OnLoad() 
	{
		this.customItemFile.load();
		CustomItemManager.getCustomItemManager().getCustomItemList().add(this);
	}
	
	@Override
	public void OnUnload() 
	{
		CustomItemManager.getCustomItemManager().getCustomItemList().remove(this);
	}
	
	@Override
	public void OnGive(Inventory inventory) 
	{
		inventory.addItem(this.toItemStack());
	}
	
	/**
	 * This method convert the custom item in a ItemStack
	 * @return The converted ItemStack
	 */
	public ItemStack toItemStack()
	{
		this.displayName = ChatColor.translateAlternateColorCodes('&', this.displayName);
		
		ItemStack itemStack = new ItemStack(this.material);
		itemStack.addUnsafeEnchantments(enchantments);
		itemStack.setAmount(this.amount);
		
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setUnbreakable(this.unbreakable);
		itemMeta.setDisplayName(this.displayName);
		
		for(int i = 0; i < this.lore.size(); i++)
		{
			String str = this.lore.get(i);
			str = ChatColor.translateAlternateColorCodes('&', str);
			this.lore.set(i, str);
		}
		itemMeta.setLore(this.lore);
		
		for(ItemFlag itemFlag : this.flags)
		{
			itemMeta.addItemFlags(itemFlag);
		}
		
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	
	/**
	 * This method set the display name of the custom item
	 * @param displayName the display name to set
	 */
	public void setDisplayName(String displayName) 
	{
		this.displayName = displayName;
	}
	
	/**
	 * This method set the lore of the custom item
	 * @param lore The lore to set
	 */
	public void setLore(List<String> lore) 
	{
		this.lore = lore;
	}
	
	/**
	 * This method set the enchantments of the custom item
	 * @param enchantments the enchantments list to set
	 */
	public void setEnchantments(Map<Enchantment, Integer> enchantments) 
	{
		this.enchantments = enchantments;
	}
	
	/**
	 * This method set the flags of the custom item
	 * @param flags The flags list to set
	 */
	public void setFlags(List<ItemFlag> flags) 
	{
		this.flags = flags;
	}
	
	/**
	 * This method set the material of the custom item
	 * @param material The material to set
	 */
	public void setMaterial(Material material) 
	{
		this.material = material;
	}
	
	/**
	 * This method set the amount of item of the custom item
	 * @param amount the amount of item to set
	 */
	public void setAmount(int amount) 
	{
		this.amount = amount;
	}
	
	/**
	 * This method set the custom item unbreakable
	 * @param unbreakable If the item is unbreakable
	 */
	public void setUnbreakable(boolean unbreakable) 
	{
		this.unbreakable = unbreakable;
	}
	
	/**
	 * This method return the display name of the custom item
	 * @return The display name of the custom item
	 */
	public String getDisplayName() 
	{
		return displayName;
	}
	
	/**
	 * This method return the file configuration of the custom item
	 * @return The file configuration of the custom item
	 */
	public DefaultCustomItemFile getCustomItemFile() 
	{
		return customItemFile;
	}
	
	/**
	 * This method return the material of the custom item
	 * @return The material of the custom item
	 */
	public Material getMaterial() 
	{
		return material;
	}
	
	/**
	 * This method return the lore of the custom item
	 * @return The lore of the custom item
	 */
	public List<String> getLore() 
	{
		return lore;
	}
	
	/**
	 * This method return the flags of the custom item
	 * @return The flags list of the custom item
	 */
	public List<ItemFlag> getFlags() 
	{
		return flags;
	}
	
	/**
	 * This method return the enchantments list of the custom item
	 * @return The enchantments list of the custom item
	 */
	public Map<Enchantment, Integer> getEnchantments() 
	{
		return enchantments;
	}
	
	/**
	 * This method return the amount of item of the custom item
	 * @return The amount of item of the custom item
	 */
	public int getAmount() 
	{
		return amount;
	}
	
	/**
	 * This methpd check if the custom item is unbreakable
	 * @return If the custom item is unbreakable
	 */
	public boolean isUnbreakable() 
	{
		return unbreakable;
	}

}
