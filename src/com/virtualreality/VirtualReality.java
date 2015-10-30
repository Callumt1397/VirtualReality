package com.virtualreality;

import java.io.File;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.virtualreality.skills.Skill;
import com.virtualreality.skills.listeners.SwordSkillListener;

public class VirtualReality extends JavaPlugin{
	
	private static VirtualReality vr;
	
	public void onEnable(){
		vr = this;
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new SwordSkillListener(), this);
		
		setupSkillFolder();
		
	}
	
	public static VirtualReality getInstance(){
		return vr;
	}
	
	public void setupSkillFolder(){
		for(Skill skill : Skill.values()){
			Config config = new Config(new File("skills"), skill.toString().toLowerCase(), this);
			config.save();
		}
	}
}
