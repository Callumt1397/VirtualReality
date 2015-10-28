package com.virtualreality.enums;

public enum Skill {

	BREWING(25), LOCKPICK(25), ENCHANTING(25), ALCHEMY(25), LIGHT_ARMOR(25), HEAVY_ARMOR(25),
	ARCHERY(25), CRAFTING(25), ONE_HANDED(25), SPEECH(25), STRENGTH(25), INTELLIGENCE(25), 
	LUCK(25);
	
	private int maxLevel;
	
	Skill(int maxLevel){
		this.maxLevel = maxLevel;
	}
	
	public int getMaxLevel(){
		return maxLevel;
	}
	
	
	
}
