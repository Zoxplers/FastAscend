package com.zoxplers.fastascend;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FastAscend extends JavaPlugin 
{
	private static FastAscend instance;
	private Config config;
	
    @Override
    public void onEnable()
    {
    	FastAscend.instance = this;
    	config = new Config(this);
    	this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }
    
    @Override
    public void onDisable()
    {
    	FastAscend.instance = null;
    }
    
	public static FastAscend getInstance()
	{
		return FastAscend.instance;
	}
	
	public YamlConfiguration getConfig()
	{
		return config;
	}
	
}
