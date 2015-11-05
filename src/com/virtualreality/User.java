package com.virtualreality;

import java.io.File;

import org.bukkit.entity.Player;

import com.virtualreality.skills.Skill;
import com.virtualreality.skills.SkillUpgrade;

public class User {

	private Player player;
	private Config config;

	public User(Player player) {
		this.player = player;
		config = new Config(new File("userdata"), player.getUniqueId().toString(), VirtualReality.getInstance());

		config.save();
	}

	public Player getPlayer() {
		return this.player;
	}

	
	/*
	* the first arg is level
	* the second arg is how far in to it.
	*/
	
	public String[] getSkillLevel(Skill skill) {
		return Double.toString(config.getConfig().getDouble("Skills." + skill.toString().toLowerCase(), 0.0)).split(".");
	}
	
	public void setSkillLevel(Skill skill, String[] args) {
		double level = Double.parseDouble(args[0] + args[1]);
		if (level <= 100) {
			config.set("skills.progression" + skill.toString().toLowerCase(), level);
			config.save();
		}
	}
	
	public void setSkillLevel(Skill skill, double level) {
		if (level <= 100) {
			config.set("skills.progression." + skill.toString().toLowerCase(), level);
			config.save();
		}
	}
	
	public SkillUpgrade[] getSkillUpgrades(Skill skill){
		//return upgrades a player owns for a certain skill
		return null;
	}
	
	public void setSkillUpgrades(Skill skill){
		//set all upgrades for a skill as a single string, each upgrade seperated by a ","
	}

}
