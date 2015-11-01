package com.virtualreality.skills.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.virtualreality.User;
import com.virtualreality.skills.Skill;
import com.virtualreality.skills.SkillsUtil;

public class SwordSkillListener implements Listener {

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (event.getEntity().getKiller() instanceof Player) {
			Player player = event.getEntity().getKiller();
			Material hand = player.getItemInHand().getType();
			if (hand == Material.WOOD_SWORD || hand == Material.STONE_SWORD || hand == Material.IRON_SWORD
					|| hand == Material.DIAMOND_SWORD) {
					User user = new User(event.getEntity().getKiller());
					user.setSkillLevelDouble(Skill.SWORDS, SkillsUtil.toDouble(user.getSkillLevel(Skill.SWORDS)) + SkillsUtil.getEntityKillValue(event.getEntityType(), Skill.SWORDS));
			}
		}
	}

}
