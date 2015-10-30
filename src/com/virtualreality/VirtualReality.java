package com.virtualreality;

import java.io.File;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.virtualreality.skills.Skill;
import com.virtualreality.skills.listeners.SwordSkillListener;

public class VirtualReality extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new SwordSkillListener(), this);
		
		setupSkillFolder();
		
	}
	
	public void setupSkillFolder(){
		for(Skill skill : Skill.values()){
			Config config = new Config(new File("skills"), skill.toString().toLowerCase(), this);
			config.save();
		}
	}
}
