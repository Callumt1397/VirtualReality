package com.virtualreality;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.virtualreality.listeners.PlayerJoinListener;
import com.virtualreality.skills.Skill;
import com.virtualreality.skills.SkillListener;

public class VirtualReality extends JavaPlugin{
	
	private static VirtualReality vr;
	
	public void onEnable(){
		vr = this;
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new SkillListener(), this);
		
		for(Skill skill : Skill.values()){
			Config config = new Config(new File("skills"), skill.toString().toLowerCase(), this);
			config.save();
		}
		
	}
	
	public static VirtualReality getInstance(){
		return vr;
	}
}
