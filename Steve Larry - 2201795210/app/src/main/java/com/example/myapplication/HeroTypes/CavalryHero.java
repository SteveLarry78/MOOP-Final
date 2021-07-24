package com.example.myapplication.HeroTypes;

public class CavalryHero extends Hero{

	private static String heroType = "Cavalry";
	private static String armyType = "Cavalry";
	private static Integer boostAmount = 40;
	private static Integer levelHero = 50;
	
	public CavalryHero() {
		super(heroType,armyType, boostAmount, levelHero);
	}
	
	public void heroLvlUp() {
		if(levelHero == 50) {
			System.out.println("Level Maxed Out!");
		}
		levelHero++;
	}
	
}
