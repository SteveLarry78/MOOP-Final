package com.example.myapplication.HeroTypes;

public class ArcherHero extends Hero {
	
	private static String heroType = "Archer";
	private static String armyType = "Archer";
	private static Integer boostAmount = 40;
	private static Integer levelHero = 50;
	
	public ArcherHero() {
		super(heroType, armyType, boostAmount, levelHero);
	}
	
	public void heroLvlUp() {
		if(levelHero == 50) {
			System.out.println("Level Maxed Out!");
		}
		levelHero++;
	}
	
	
}
