package com.example.myapplication.HeroTypes;

public class CatapultHero extends Hero{
	
	private static String heroType = "Catapult";
	private static String armyType = "Catapult";
	private static Integer boostAmount = 40;
	private static Integer levelHero = 50;
	
	public CatapultHero() {
		super(heroType,armyType, boostAmount, levelHero);
	}
	
	public void heroLvlUp() {
		if(levelHero == 50) {
			System.out.println("Level Maxed Out!");
		}
		levelHero++;
	}
	
}
