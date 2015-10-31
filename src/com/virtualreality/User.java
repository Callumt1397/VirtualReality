package com.virtualreality;

import java.io.File;

import org.bukkit.entity.Player;

import com.virtualreality.skills.Skill;
import com.virtualreality.traits.Trait;

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
	* the second arg is how for in to it.
	*/
	
	public String[] getSkillLevel(Skill skill) {
		return Double.toString(config.getConfig().getDouble("Skills." + skill.toString().toLowerCase(), 0.0)).split(".");
	}
	
	public void setSkillLevel(Skill skill, String[] args) {
		double level = Double.parseDouble(args[0] + args[1]);
		if (level < skill.getMaxLevel()) {
			config.set("Skills." + skill.toString().toLowerCase(), level);
			config.save();
			
			this.player.sendMessage("Skill Level: " + getSkillLevel(skill));
		}
	}
	
	public void setSkillLevelDouble(Skill skill, double level) {
		if (level < skill.getMaxLevel()) {
			config.set("Skills." + skill.toString().toLowerCase(), level);
			config.save();
			
			this.player.sendMessage("Skill Level: " + getSkillLevel(skill));
		}
	}

	public boolean hasTrait(Trait trait) {
		if (config.getConfig().contains("Trait." + trait.toString().toLowerCase()))
			return true;
		return false;
	}

	public void addTrait(Trait trait) {
		if (!hasTrait(trait))
			config.getConfig().createSection("Trait." + trait.toString().toLowerCase());
	}

	public void removeTrait(Trait trait) {
		if (hasTrait(trait)) {
			config.getConfig().set("Trait." + trait.toString().toLowerCase(), null);
			config.save();
		}
	}

}
