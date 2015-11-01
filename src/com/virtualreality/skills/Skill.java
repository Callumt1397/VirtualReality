package com.virtualreality.skills;

public enum Skill {

	//General Skills
	SWORDS(10), AXES(100), ARCHERY(100), CRAFTING(100), BREWING(100),  
	
	//Special Skills
	LUCK(10), INTELLIGENCE(10), STRENGTH(10);
	
	private int maxLevel;
	
	Skill(int maxLevel){
		this.maxLevel = maxLevel;
	}
	
	public int getMaxLevel(){
		return maxLevel;
	}
	
	
	
}
