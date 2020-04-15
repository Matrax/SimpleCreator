package com.fr.matrax.simplecreator.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.fr.matrax.simplecreator.managers.CustomMobManager;
import com.fr.matrax.simplecreator.mobs.CustomMob;

public class CustomMobListener implements Listener 
{
	
	@EventHandler
	public void OnKill(EntityDeathEvent event)
	{
		for(CustomMob customMob : CustomMobManager.getCustomMobManager().getCustomMobs())
		{
			customMob.OnKill(event);
		}
	}
	

}
