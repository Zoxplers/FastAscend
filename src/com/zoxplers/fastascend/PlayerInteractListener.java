package com.zoxplers.fastascend;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerInteractListener implements Listener
{
	//Constants
	final double CLIMBPITCH = -50, CLIMBSPEED = 0.4;
	
	//Variables
	ArrayList<Material> interactables, intangibles;
	
	//Constructor
	public PlayerInteractListener()
	{
		interactables = new ArrayList<Material>();
		intangibles = new ArrayList<Material>();
		
        interactables.add(Material.VINE);
        interactables.add(Material.LADDER);
        
        intangibles.add(Material.WATER);
        if(!((Config) FastAscend.getInstance().getConfig()).getOnlyFastSwim())
        {
	        intangibles.add(Material.VINE);
	        intangibles.add(Material.LADDER);
        }
	}
	
	//Functions
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
        Location location;
        Player player = event.getPlayer();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock() != null && player.getInventory().getItemInMainHand().getType() == Material.AIR && interactables.contains(event.getClickedBlock().getType()))
		{
			location = event.getClickedBlock().getLocation();
			if(Math.abs(player.getLocation().getX() - location.getX()) < 3 && Math.abs(player.getLocation().getZ() - location.getZ()) < 3)
			{
				while(interactables.contains(location.add(0,1,0).getBlock().getType()))
				{
	                player.playSound(location,Sound.BLOCK_LADDER_STEP,1,1);
				}
				location.add(0.5, -1, 0.5);
				if(!interactables.contains(location.add(0, -1, 0).getBlock().getType()))
				{
					location.add(0, 1, 0);
				}
				location.setDirection(player.getLocation().getDirection());
				player.teleport(location);
			}
			else
			{
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ((Config)FastAscend.getInstance().getConfig()).getPrefix() + " too far to fastclimb!"));
			}
		}
	}
	
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
		Player player = event.getPlayer();
		if(player.getLocation().getPitch() < CLIMBPITCH && event.getTo().getY()-event.getFrom().getY() > 0.1 && intangibles.contains(player.getLocation().add(0,1.1,0).getBlock().getType()))
    	{
    		player.setVelocity(player.getVelocity().clone().setY(CLIMBSPEED));
    	}
    }
}
