package com.virtualreality.skills.listeners;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.virtualreality.Config;
import com.virtualreality.User;
import com.virtualreality.VirtualReality;
import com.virtualreality.skills.Skill;

public class SwordSkillListener implements Listener {

	private Config config = new Config(new File("skills"), "swords", VirtualReality.getInstance());

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (event.getEntity().getKiller() instanceof Player) {
			Player player = event.getEntity().getKiller();
			Material hand = player.getItemInHand().getType();
			if (hand == Material.WOOD_SWORD || hand == Material.STONE_SWORD || hand == Material.IRON_SWORD
					|| hand == Material.DIAMOND_SWORD) {
					User user = new User(event.getEntity().getKiller());
					user.setSkillLevel(Skill.SWORDS,
							user.getSkillLevel(Skill.SWORDS) + getEntityKillValue(event.getEntityType()));
			}
		}
	}

	public double getEntityKillValue(EntityType type) {
		if (!config.getConfig().contains(type.toString().toLowerCase()))
			return 0;
		return config.getConfig().getDouble(type.toString().toLowerCase());
	}

}
