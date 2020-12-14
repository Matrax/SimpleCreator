package com.fr.matrax.simplecreator.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * @version 1.0
 * @author alexa
 *
 */
public class LocationConverter 
{
	
	/**
	 * This function convert a string to a location
	 * @param str The string to convert
	 * @return The location from the string
	 */
	public static Location getLocationFromString(String str)
	{
		String[] options = str.split(":");
		Location location = null;
		if(options.length == 4)
		{
			World world = Bukkit.getWorld(options[0]);
			float x = Float.valueOf(options[1]);
			float y = Float.valueOf(options[2]);
			float z = Float.valueOf(options[3]);
			location = new Location(world, x, y, z);
		}
		return location;
	}
	
	/**
	 * This function convert a location to a string
	 * @param location The location to convert
	 * @return The string from the location
	 */
	public static String getStringFromLocation(Location location)
	{
		return location.getWorld().getName() 
				+ ":" + location.getX() 
				+ ":" + location.getY() 
				+ ":" + location.getZ();
	}

}
