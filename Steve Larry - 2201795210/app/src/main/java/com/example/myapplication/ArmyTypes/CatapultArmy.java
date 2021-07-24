package com.example.myapplication.ArmyTypes;

import com.example.myapplication.Player;
import com.example.myapplication.HeroTypes.*;

public class CatapultArmy extends Army {
	
	public CatapultArmy() {
		super("Catapult", 0, 0, 1);
	}
	
	@Override
	public void checkCastleBoost(Player player) {
		if(player.getCurrentCastle().getSkinCastle().equalsIgnoreCase("Stone")) {
			this.setBoostSkill(20);
		}else {
			this.setBoostSkill(0);
		}
	}
	
	@Override
	public void checkHeroBoost(Player player) {
		int currBoost = 0;
		for (Hero hero : player.getHeroList()) {
			if(hero.getArmyType().equalsIgnoreCase("Catapult")) {
				currBoost += 40;
			}
		}
		this.setBoostAttack(currBoost);
	}
	
}
