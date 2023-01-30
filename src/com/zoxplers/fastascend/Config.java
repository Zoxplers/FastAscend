package com.zoxplers.fastascend;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config extends YamlConfiguration
{
    private Plugin plugin;
    private String prefix;
    private double pitch, speed;
    private boolean onlyFastSwim;
    
    /*
	public Config(Plugin plugin)
	{
        this.plugin = plugin;
        this.addDefault("prefix", prefix);
        this.addDefault("pitch", -50.0);
        this.addDefault("speed", 0.4);
	}
	*/
	public Config(Plugin plugin)
	{
        this.plugin = plugin;
        prefix = "&bFastAscend&a";
        pitch = -50.0;
        speed = 0.4;
        onlyFastSwim = true;
	}
	
	public String getPrefix()
	{
		return prefix;
	}
	
	public double getPitch()
	{
		return pitch;
	}
	
	public double getSpeed()
	{
		return speed;
	}
	
	public boolean getOnlyFastSwim()
	{
		return onlyFastSwim;
	}
	
	/*
    public void save()
    {
        try
        {
        	this.set("prefix", prefix);
        	this.set("pitch", pitch);
        	this.set("speed", speed);
        }
        catch (Exception ex)
        {
            plugin.getLogger().severe("An error occurred while trying to save the config file (" + file.getAbsolutePath() + "): " + ex.getMessage());
        }
    }
    
    public boolean load()
    {
        try
        {
            prefix = this.getString("prefix");
            pitch = this.getDouble("pitch");
            speed = this.getDouble("speed");
        }
        catch (Exception ex)
        {
            plugin.getLogger().severe("An error occurred while trying to load the config file (" + file.getAbsolutePath() + "): " + ex.getMessage());
            return false;
        }
        return true;
    }
    */
}
