package com.example.myapplication.ArmyTypes;

import com.example.myapplication.Player;

public abstract class Army {
	
	private String armyType;
	private Integer boostAttack;
	private Integer boostSkill;
	private Integer armyAmount;
	
	public abstract void checkCastleBoost(Player player);
	public abstract void checkHeroBoost(Player player);
	
	public Army(String armyType, Integer boostAttack, Integer boostSkill, Integer armyAmount) {
		super();
		this.armyType = armyType;
		this.boostAttack = boostAttack;
		this.boostSkill = boostSkill;
		this.armyAmount = armyAmount;
	}
	public String getArmyType() {
		return armyType;
	}
	public void setArmyType(String armyType) {
		this.armyType = armyType;
	}
	public Integer getBoostAttack() {
		return boostAttack;
	}
	public void setBoostAttack(Integer boostAttack) {
		this.boostAttack = boostAttack;
	}
	public Integer getBoostSkill() {
		return boostSkill;
	}
	public void setBoostSkill(Integer boostSkill) {
		this.boostSkill = boostSkill;
	}
	public Integer getArmyAmount() {
		return armyAmount;
	}
	public void setArmyAmount(Integer armyAmount) {
		this.armyAmount = armyAmount;
	}
	
	
	
}
