package com.virtualreality.skills;

public enum SkillUpgrade {

	/*Values taken from here http://www.uesp.net/wiki/Skyrim:Skills
	* Spent just over 10 minutes typing these in, not going to type anymore until we decide if this 
	* is how we will do it or if we should do it another way
	*/
	
	//ALTERATION
	NOVICE_ALTERATION(Skill.ALTERATION, 0), 
	ALTERATION_DUAL_CASTING(Skill.ALTERATION, 20, SkillUpgrade.NOVICE_ALTERATION), 
	APPRENTICE_ALTERATION(Skill.ALTERATION, 25, SkillUpgrade.NOVICE_ALTERATION), 
	MAGE_ARMOR(Skill.ALTERATION, 50, SkillUpgrade.APPRENTICE_ALTERATION), 
	MAGIC_RESISTANCE(Skill.ALTERATION, 50, SkillUpgrade.APPRENTICE_ALTERATION), 
	ADEPT_ALTERATION(Skill.ALTERATION, 50, SkillUpgrade.APPRENTICE_ALTERATION),
	STABILITY(Skill.ALTERATION, 70, SkillUpgrade.ADEPT_ALTERATION), 
	EXPERT_ALTERATION(Skill.ALTERATION, 75, SkillUpgrade.ADEPT_ALTERATION),
	ATRONACH(Skill.ALTERATION, 100, SkillUpgrade.EXPERT_ALTERATION), 
	MASTER_ALTERATION(Skill.ALTERATION, 100, SkillUpgrade.EXPERT_ALTERATION),
	
	//CONJURATION
	NOVICE_CONJURATION(Skill.CONJURATION, 0), 
	SUMMONER(Skill.CONJURATION, 30, SkillUpgrade.NOVICE_CONJURATION), 
	ATROMANCY(Skill.CONJURATION, 40, SkillUpgrade.SUMMONER),
	ELEMENTAL_POTENCY(Skill.CONJURATION, 80, SkillUpgrade.ATROMANCY), 
	CONJURATION_DUAL_CASTING(Skill.CONJURATION, 20, SkillUpgrade.NOVICE_CONJURATION),
	NECROMANCY(Skill.CONJURATION, 40, SkillUpgrade.NOVICE_CONJURATION), 
	DARK_SOULS(Skill.CONJURATION, 70, SkillUpgrade.NECROMANCY),
	TWIN_SOULS(Skill.CONJURATION, 100, SkillUpgrade.ELEMENTAL_POTENCY, SkillUpgrade.DARK_SOULS), 
	MYSTIC_BINDING(Skill.CONJURATION, 20, SkillUpgrade.NOVICE_CONJURATION),
	SOUL_STEALER(Skill.CONJURATION, 30, SkillUpgrade.MYSTIC_BINDING), 
	OBLIVION_BINDING(Skill.CONJURATION, 50, SkillUpgrade.SOUL_STEALER),
	APPRENTICE_CONJURATION(Skill.CONJURATION, 25, SkillUpgrade.NOVICE_CONJURATION), 
	ADEPT_CONJURATION(Skill.CONJURATION, 50, SkillUpgrade.APPRENTICE_CONJURATION),
	EXPERT_CONJURATION(Skill.CONJURATION, 75, SkillUpgrade.ADEPT_CONJURATION), 
	MASTER_CONJURATION(Skill.CONJURATION, 75, SkillUpgrade.EXPERT_CONJURATION),
	
	//DESTRUCTION
	NOVICE_DESTRUCTION(Skill.DESTRUCTION, 0), 
	AUGMENTED_FLAMES(Skill.DESTRUCTION, 30, SkillUpgrade.NOVICE_DESTRUCTION), 
	INTENSE_FLAMES(Skill.DESTRUCTION, 50, SkillUpgrade.AUGMENTED_FLAMES),
	AUGMENTED_FROST(Skill.DESTRUCTION, 30, SkillUpgrade.NOVICE_DESTRUCTION), 
	DEEP_FREEZE(Skill.DESTRUCTION, 60, SkillUpgrade.AUGMENTED_FROST), 
	AUGMENTED_SHOCK(Skill.DESTRUCTION, 30, SkillUpgrade.NOVICE_DESTRUCTION), 
	DISITIGRATE(Skill.DESTRUCTION, 70, SkillUpgrade.AUGMENTED_SHOCK), 
	APPRENTICE_DESTRUCTION(Skill.DESTRUCTION, 25, SkillUpgrade.NOVICE_DESTRUCTION), 
	RUNE_MASTER(Skill.DESTRUCTION, 40, SkillUpgrade.APPRENTICE_DESTRUCTION),
	ADEPT_DESTRUCTION(Skill.DESTRUCTION, 50, SkillUpgrade.APPRENTICE_DESTRUCTION),
	EXPERT_DESTRUCTION(Skill.DESTRUCTION, 75, SkillUpgrade.ADEPT_DESTRUCTION),
	MASTER_DESTRUCTION(Skill.DESTRUCTION, 100, SkillUpgrade.EXPERT_DESTRUCTION),
	DESTRUCTION_DUAL_CASTING(Skill.DESTRUCTION, 20, SkillUpgrade.NOVICE_DESTRUCTION),
	IMPACT(Skill.DESTRUCTION, 40, SkillUpgrade.DESTRUCTION_DUAL_CASTING),
	
	//ENCHANTING
	ENCHANTER(Skill.ENCHANTING, 0), 
	FIRE_ENCHANTER(Skill.ENCHANTING, 30, SkillUpgrade.ENCHANTER),
	FROST_ENCHANTER(Skill.ENCHANTING, 40, SkillUpgrade.FIRE_ENCHANTER),
	STORM_ENCHANTER(Skill.ENCHANTING, 50, SkillUpgrade.FROST_ENCHANTER),
	INSIGHTFUL_ENCHANTER(Skill.ENCHANTING, 50, SkillUpgrade.ENCHANTER),
	CORPUS_ENCHANTER(Skill.ENCHANTING, 75, SkillUpgrade.INSIGHTFUL_ENCHANTER),
	EXTRA_EFFECT(Skill.ENCHANTING, 100, SkillUpgrade.CORPUS_ENCHANTER),
	SOUL_SQUEEZER(Skill.ENCHANTING, 20, SkillUpgrade.ENCHANTER),
	SOUL_SIPHONE(Skill.ENCHANTING, 40, SkillUpgrade.SOUL_SQUEEZER);

	private int neededSkillLevel;
	private Skill skill;
	private SkillUpgrade[] neededUpgrades;
	
	SkillUpgrade(Skill skill, int neededSkillLevel, SkillUpgrade... neededUpgrade){
		this.neededUpgrades = neededUpgrade;
		this.neededSkillLevel = neededSkillLevel;
		this.skill = skill;
	}
	
	public SkillUpgrade[] getNeededUpgrades(){
		return this.neededUpgrades;
	}
	
	public int getNeededSkillLevel(){
		return neededSkillLevel;
	}
	
	public Skill getSkillType(){
		return skill;
	}
	
	public SkillUpgrade[] getNextUpgrades(SkillUpgrade current){
		SkillUpgrade[] upgrades = {};
		for(SkillUpgrade upgrade : values()){
			if(upgrade.equals(current)){
				upgrades[upgrades.length] = upgrade;
			}
		}
		return upgrades;
	}
	
	public static SkillUpgrade fromString(String string){
		for(SkillUpgrade upgrade : values()){
			if(upgrade.toString().replaceAll("_", "").equalsIgnoreCase(string)){
				return upgrade;
			}
		}
		return null;
	}
	
}
