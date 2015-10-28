package com.virtualreality;

import java.io.File;

import org.bukkit.entity.Player;

import com.virtualreality.enums.Skill;
import com.virtualreality.enums.Trait;

public class User {

	private Player player;
	private Config config;

	public User(Player player) {
		this.player = player;
		config = new Config(new File("userdata"), player.getUniqueId().toString(), VirtualReality.getInstance());

		setDefaults();
	}

	public Player getPlayer() {
		return this.player;
	}

	public int getSkillLevel(Skill skill) {
		if (!config.getConfig().contains("Skills." + skill))
			return 0;
		return config.getConfig().getInt("Skills." + skill);
	}

	public void setSkillLevel(Skill skill, int level) {
		if (level < skill.getMaxLevel()) {
			config.set("Skills." + skill, level);
			config.save();
		}
	}

	public boolean hasTrait(Trait trait) {
		if (config.getConfig().contains("Trait." + trait))
			return true;
		return false;
	}
	
	public void giveTrait(Trait trait){
		if(!hasTrait(trait))
			config.getConfig().createSection("Trait." + trait);
	}

	// Setting all defaults to the players file

	public void setDefaults() {
		if (!config.getConfig().contains("DeleteThisToResetConfig")) {
			config.set("Info.Kills", 0);
			config.set("Info.Deaths", 0);

			for (Skill skill : Skill.values()) {
				config.set("Skills." + skill, 0);
			}

			config.save();
		}
	}

}
