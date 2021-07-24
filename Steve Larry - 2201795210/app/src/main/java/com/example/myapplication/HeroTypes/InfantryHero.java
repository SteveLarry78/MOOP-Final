package com.example.myapplication.HeroTypes;

public class InfantryHero extends Hero{

	private static String heroType = "Infantry";
	private static String armyType = "Infantry";
	private static Integer boostAmount = 40;
	private static Integer levelHero = 50;
	
	public InfantryHero() {
		super(heroType, armyType, boostAmount, levelHero);
	}
	
	public void heroLvlUp() {
		if(levelHero == 50) {
			System.out.println("Level Maxed Out!");
		}
		levelHero++;
	}
	
}
