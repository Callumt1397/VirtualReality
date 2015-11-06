package com.virtualreality.skills.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.virtualreality.skills.Skill;

public class SkillLevelUpEvent extends Event{
	
	private static final HandlerList handlers = new HandlerList();
	 
	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}
	
	private int newLevel;
	private Skill skill;
	
	public SkillLevelUpEvent(Skill skill, int newLevel){
		this.skill = skill;
		this.newLevel = newLevel;
	}
	
	public Skill getSkill(){
		return skill;
	}
	
	public int getOldLevel(){
		return newLevel - 1;
	}
	
	public int getNewLevel(){
		return newLevel;
	}
	
	

}
