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

	
	//Using a double since the integer part can be used to define a players level
	//and the decimal part can be used to show how far through the rank they are
	//e.g. 5.09 means level 5 and 0.9% through the rank
	public double getSkillLevel(Skill skill) {
		if (!config.getConfig().contains("Skills." + skill.toString().toLowerCase()))
			return 0;
		return config.getConfig().getDouble("Skills." + skill.toString().toLowerCase());
	}

	public void setSkillLevel(Skill skill, double level) {
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
