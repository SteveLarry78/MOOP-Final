package com.example.myapplication.ArmyTypes;

import com.example.myapplication.HeroTypes.*;
import com.example.myapplication.Player;

public class CavalryArmy extends Army {
	
	public CavalryArmy() {
		super("Cavalry", 0, 0, 1);
	}
	
	@Override
	public void checkCastleBoost(Player player) {
		if(player.getCurrentCastle().getSkinCastle().equalsIgnoreCase("Horse")) {
			this.setBoostSkill(20);
		}else {
			this.setBoostSkill(0);
		}
	}
	
	@Override
	public void checkHeroBoost(Player player) {
		int currBoost = 0;
		for (Hero hero : player.getHeroList()) {
			if(hero.getArmyType().equalsIgnoreCase("Cavalry")) {
				currBoost += 40;
			}
		}
		this.setBoostAttack(currBoost);
	}
	
}
