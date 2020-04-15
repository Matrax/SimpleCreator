package com.fr.matrax.simplecreator.commands;

import java.util.List;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.fr.matrax.simplecreator.items.DefaultCustomItem;
import com.fr.matrax.simplecreator.managers.CustomItemManager;
import com.fr.matrax.simplecreator.managers.CustomMobManager;
import com.fr.matrax.simplecreator.mobs.CustomMob;
import com.fr.matrax.simplecreator.mobs.DefaultCustomMob;

public class CustomMobCommand {
	
	/**
	 * This method use the command for create a new custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void createMobCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.createmob") == true || player.isOp())
		{
			if(args.length == 2)
			{
				if(CustomMobManager.getCustomMobManager().contains(args[1]) == true)
				{
					player.sendMessage("§cThis custom mob already exist !");
					return;
				}
				
				DefaultCustomMob customMob = new DefaultCustomMob(args[1]);
				customMob.load();
				player.sendMessage("§aYou created the custom mob §e" + customMob.getName());
			} else {
				player.sendMessage("§cDo /mtxlib createmob {name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for spawn a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void spawnMobCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.spawnmob") == true || player.isOp())
		{
			if(args.length == 2)
			{
				CustomMob customMob = CustomMobManager.getCustomMobManager().getByName(args[1]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.spawn(player.getLocation());
				player.sendMessage("§aYou spawned the custom mob §e" + customMob.getName());
			} else {
				player.sendMessage("§cDo /mtxlib spawnmob {name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the custom mob name
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void infoMobCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.mobinfo") == true || player.isOp())
		{
			if(args.length == 2)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				player.sendMessage("§6==========MOB INFO==========");
				player.sendMessage("§aDisplay Name: §e" + customMob.getDisplayName());
				player.sendMessage("§aHealth: §e" + customMob.getHealth());
				player.sendMessage("§aEntity Type: §e" + customMob.getEntityType());
				player.sendMessage("§aAI: §e" + customMob.hasAI());
				player.sendMessage("§aGravity: §e" + customMob.hasGravity());
				player.sendMessage("§aCollidable: §e" + customMob.isCollidable());
				player.sendMessage("§aGliding: §e" + customMob.isGliding());
				player.sendMessage("§aGlowing: §e" + customMob.isGlowing());
				player.sendMessage("§aDropped XP: §e" + customMob.getDroppedXp());
				player.sendMessage("§aFire Ticks: §e" + customMob.getFireTicks());
				player.sendMessage("§6==========MOB INFO==========");
			} else {
				player.sendMessage("§cDo /mtxlib mobinfo {name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the custom mob name
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setMobNameCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setmobname") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setDisplayName(args[2]);
				customMob.getCustomMobFile().set("display_name", args[2]);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has a new display name : §e" + args[2]);
			} else {
				player.sendMessage("§cDo /mtxlib setmobname {name} {display name}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the AI of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setAICommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setai") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				boolean ai = Boolean.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setAI(ai);
				customMob.getCustomMobFile().set("AI", ai);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a AI : §e" + ai);
			} else {
				player.sendMessage("§cDo /mtxlib setai {name} {boolean}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set collidable a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setCollidableCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setcollidable") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				boolean collidable = Boolean.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setCollidable(collidable);
				customMob.getCustomMobFile().set("collidable", collidable);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a collision : §e" + collidable);
			} else {
				player.sendMessage("§cDo /mtxlib setcollidable {name} {boolean}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set gliding a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setGlidingCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setgliding") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				boolean gliding = Boolean.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setGliding(gliding);
				customMob.getCustomMobFile().set("gliding", gliding);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a can glide : §e" + gliding);
			} else {
				player.sendMessage("§cDo /mtxlib setgliding {name} {boolean}");
			}
		} else {
			player.sendMessage("Â§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set glowing a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setGlowingCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setglowing") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				boolean glowing = Boolean.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setGlowing(glowing);
				customMob.getCustomMobFile().set("glowing", glowing);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a can glow : §e" + glowing);
			} else {
				player.sendMessage("§cDo /mtxlib setglowing {name} {boolean}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the gravity of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setGravityCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setgravity") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				boolean gravity = Boolean.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setGravity(gravity);
				customMob.getCustomMobFile().set("gravity", gravity);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has gravity : §e" + gravity);
			} else {
				player.sendMessage("§cDo /mtxlib setgravity {name} {boolean}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the default drop of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setDefaultDropCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setdefaultdrop") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				boolean defaultDrop = Boolean.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setDefaultDrop(defaultDrop);
				customMob.getCustomMobFile().set("default_drop", defaultDrop);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob Â§e" + customMob.getName() + "§a has default drop : §e" + defaultDrop);
			} else {
				player.sendMessage("§cDo /mtxlib setdefaultdrop {name} {boolean}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * Command for set the health of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setHealthCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.sethealth") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				int health = Integer.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setHealth(health);
				customMob.getCustomMobFile().set("health", health);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has max health : §e" + health);
			} else {
				player.sendMessage("§cDo /mtxlib sethealth {name} {max health}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the dropped experience of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setDroppedXpCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setdroppedxp") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				int xp = Integer.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setDroppedXp(xp);
				customMob.getCustomMobFile().set("dropped_xp", xp);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a experience drop is now : §e" + xp);
			} else {
				player.sendMessage("§cDo /mtxlib setdroppedxp {name} {xp}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set fire ticks of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setFireTicksCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setfireticks") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				int ticks = Integer.valueOf(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				customMob.setFireTicks(ticks);
				customMob.getCustomMobFile().set("fire_ticks", ticks);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a fire ticks is now : §e" + ticks);
			} else {
				player.sendMessage("§cDo /mtxlib setfireticks {name} {ticks}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the entity type of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setTypeCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.settype") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				EntityType type = EntityType.valueOf(args[2].toUpperCase());
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(type == null)
				{
					player.sendMessage("§cThis entity type doesn't exist !");
					return;
				}
				
				customMob.setEntityType(type);
				customMob.getCustomMobFile().set("entity_type", args[2].toUpperCase());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a type is : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib settype {name} {type}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for add a custom drop of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void addDropCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.adddrop") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				List<String> items = customMob.getCustomMobFile().getStringList("drops");
				items.add(customItem.getName());
				customMob.getDrops().add(customItem);
				customMob.getCustomMobFile().set("drops", items);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has a new drop : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib adddrop {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the main hand item of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setMainHandCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setmainhand") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customMob.getCustomMobEquipment().setMainHand(customItem);
				customMob.getCustomMobFile().set("main_hand.item", customItem.getName());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has main hand item : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib setmainhand {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the off hand of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setOffHandCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setoffhand") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customMob.getCustomMobEquipment().setOffHand(customItem);
				customMob.getCustomMobFile().set("off_hand.item", customItem.getName());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has off hand item : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib setoffhand {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the helmet item of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setHelmetCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.sethelmet") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customMob.getCustomMobEquipment().setHelmet(customItem);
				customMob.getCustomMobFile().set("helmet.item", customItem.getName());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has helmet item : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib sethelmet {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the chestplate item of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setChestplateCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setchestplate") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customMob.getCustomMobEquipment().setChestplate(customItem);
				customMob.getCustomMobFile().set("chestplate.item", customItem.getName());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has chestplate item : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib setchestplate {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the legging item of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setLeggingsCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setleggings") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customMob.getCustomMobEquipment().setLeggings(customItem);
				customMob.getCustomMobFile().set("leggings.item", customItem.getName());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has leggings item : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib setleggings {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for set the boot item of a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void setBootsCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.setboots") == true || player.isOp())
		{
			if(args.length == 3)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				DefaultCustomItem customItem = (DefaultCustomItem) CustomItemManager.getCustomItemManager().getByName(args[2]);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(customItem == null)
				{
					player.sendMessage("§cThis custom item doesn't exist !");
					return;
				}
				
				customMob.getCustomMobEquipment().setBoots(customItem);
				customMob.getCustomMobFile().set("boots.item", customItem.getName());
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob Â§e" + customMob.getName() + "§a has boots item : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib setboots {name} {custom item}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
	/**
	 * This method use the command for add a new potion effect to a custom mob
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public static void addPotionEffectCommand(Player player, String[] args)
	{
		if(player.hasPermission("mtxlib.command.addpotioneffect") == true || player.isOp())
		{
			if(args.length == 5)
			{
				DefaultCustomMob customMob = (DefaultCustomMob) CustomMobManager.getCustomMobManager().getByName(args[1]);
				PotionEffectType potionEffectType = PotionEffectType.getByName(args[2]);
				int duration = Integer.valueOf(args[3]);
				int amplifier = Integer.valueOf(args[4]);
				PotionEffect potionEffect = new PotionEffect(potionEffectType, duration, amplifier);
				
				if(customMob == null)
				{
					player.sendMessage("§cThis custom mob doesn't exist !");
					return;
				}
				
				if(potionEffectType == null)
				{
					player.sendMessage("§cThis potion effect doesn't exist !");
					return;
				}
				
				if(duration < 1)
				{
					player.sendMessage("§cDuration > 1 !");
					return;
				}
				
				if(amplifier < 1)
				{
					player.sendMessage("§cAmplifier > 1 !");
					return;
				}
				
				List<String> potions = customMob.getCustomMobFile().getStringList("potion_effects");
				potions.add(args[2].toUpperCase() + ":" + duration + ":" + amplifier);
				customMob.getPotionEffects().add(potionEffect);
				customMob.getCustomMobFile().set("potion_effects", potions);
				customMob.getCustomMobFile().save();
				player.sendMessage("§aThe custom mob §e" + customMob.getName() + "§a has a new potion effect : §e" + args[2].toUpperCase());
			} else {
				player.sendMessage("§cDo /mtxlib addpotioneffect {name} {potion effect} {duration} {amplifier}");
			}
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}

}
