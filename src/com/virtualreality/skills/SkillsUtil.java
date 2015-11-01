package com.virtualreality.skills;

import java.io.File;

import org.bukkit.entity.EntityType;

import com.virtualreality.Config;
import com.virtualreality.VirtualReality;

public class SkillsUtil {

	public static double toDouble(String[] args){
		return Double.parseDouble(args[0] + args[1]);
	}
	
	public static double getEntityKillValue(EntityType type, Skill s) {
		return new Config(new File("skills"), s.name().toLowerCase(), VirtualReality.getInstance()).getConfig().getDouble(type.toString().toLowerCase(),0);
	}
	
}
