package com.example.myapplication.HeroTypes;

public abstract class Hero {
	
	private String heroType;
	private String armyType;
	private Integer boostAmount;
	private Integer levelHero;

	public Hero(String heroType, String armyType, Integer boostAmount, Integer levelHero) {
		super();
		this.heroType = heroType;
		this.armyType = armyType;
		this.boostAmount = boostAmount;
		this.levelHero = levelHero;
	}

	public abstract void heroLvlUp();	
	
	public String getArmyType() {
		return armyType;
	}
	public void setArmyType(String armyType) {
		this.armyType = armyType;
	}
	public Integer getBoostAmount() {
		return boostAmount;
	}
	public void setBoostAmount(Integer boostAmount) {
		this.boostAmount = boostAmount;
	}
	public Integer getLevelHero() {
		return levelHero;
	}
	public void setLevelHero(Integer levelHero) {
		this.levelHero = levelHero;
	}
	public String getHeroType() {
		return heroType;
	}
	public void setHeroType(String heroType) {
		this.heroType = heroType;
	}
	
}
