package com.fr.matrax.simplecreator.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.fr.matrax.simplecreator.managers.CustomMobManager;
import com.fr.matrax.simplecreator.mobs.CustomMob;
import com.fr.matrax.simplecreator.mobs.DefaultCustomMob;

/**
 * This class represent the listener of all the default custom mob
 * @version 1.0
 * @author _Matrax_
 */
public class CustomMobListener implements Listener 
{
	
	@EventHandler
	public void OnKill(EntityDeathEvent event)
	{
		CustomMobManager manager = CustomMobManager.getCustomMobManager();
		for(CustomMob customMob : manager.getCustomMobList().getArray())
		{
			if(customMob instanceof DefaultCustomMob == false) continue;
			DefaultCustomMob mob = (DefaultCustomMob) customMob;
			
			for(LivingEntity entity : mob.getEntityList().getArray())
			{
				if(entity == event.getEntity()) customMob.OnKill(event);
			}
		}
	}
	

}
