package com.example.myapplication;

import java.util.Vector;
import com.example.myapplication.CastleSkins.*;
import com.example.myapplication.ArmyTypes.*;
import com.example.myapplication.HeroTypes.*;

public class Player {

	private Integer playerNumber;
	private Castle currentCastle = null;
	private Vector<Army> armyList = new Vector<>();
	private Vector<Hero> heroList = new Vector<>();


	public Player(Integer playerNumber) {
		this.playerNumber = playerNumber;
	}

	public void addArmy(String armyType) {
		for (Army army : armyList) {
			if(army.getArmyType().equalsIgnoreCase(armyType)){
				army.setArmyAmount(army.getArmyAmount()+1);
				return;
			}
		}
		if(armyType.equalsIgnoreCase("Archer")){
			armyList.add(new ArcherArmy());
		}else if(armyType.equalsIgnoreCase("Catapult")) {
			armyList.add(new CatapultArmy());
		}else if(armyType.equalsIgnoreCase("Cavalry")) {
			armyList.add(new CavalryArmy());
		}else if(armyType.equalsIgnoreCase("Infantry")) {
			armyList.add(new InfantryArmy());
		}
	}

	public void setArmyAmount(String armyType,int amount){
		for (Army army : armyList) {
			if(army.getArmyType().equalsIgnoreCase(armyType)){
				army.setArmyAmount(amount);
				return;
			}
		}
	}

	public int[] armyPower(){
		int power[] = new int[4];
		for (Army army : armyList) {
			army.checkHeroBoost(this);
			if(army.getArmyType().equalsIgnoreCase("Archer")){
				power[0] = army.getBoostAttack()*army.getArmyAmount()/100 + army.getArmyAmount();
				System.out.println(power[0]);
			}else if(army.getArmyType().equalsIgnoreCase("Catapult")){
				power[1] = army.getBoostAttack()*army.getArmyAmount()/100+ army.getArmyAmount();
			}else if(army.getArmyType().equalsIgnoreCase("Cavalry")){
				power[2] = army.getBoostAttack()*army.getArmyAmount()/100+ army.getArmyAmount();
				System.out.println(power[2]);
			}else if(army.getArmyType().equalsIgnoreCase("Infantry")){
				power[3] = army.getBoostAttack()*army.getArmyAmount()/100+ army.getArmyAmount();
			}
		}
		return power;
	}

	public void addHero(String heroType) {
		if(heroType.equalsIgnoreCase("Archer")) {
			heroList.add(new ArcherHero());
		}else if(heroType.equalsIgnoreCase("Catapult")) {
			heroList.add(new CatapultHero());
		}else if(heroType.equalsIgnoreCase("Cavalry")) {
			heroList.add(new CavalryHero());
		}else if(heroType.equalsIgnoreCase("Infantry")) {
			heroList.add(new InfantryHero());
		}
	}

	public void castleChangeSkin(String newSkin) {
		if(newSkin.equalsIgnoreCase("Horse")) {
			currentCastle = new HorseCastle();
		}else if(newSkin.equalsIgnoreCase("Wood")) {
			currentCastle = new WoodCastle();
		}else if(newSkin.equalsIgnoreCase("Steel")) {
			currentCastle = new SteelCastle();
		}else if(newSkin.equalsIgnoreCase("Stone")) {
			currentCastle = new StoneCastle();
		}
	}

	public void viewStats() {
		viewStatsCastle();
		System.out.println("------------------------\n");
		viewStatsHero();
		System.out.println("------------------------\n");
		viewStatsArmy();
		System.out.println("------------------------\n");
	}

	public void viewStatsArmy() {
		System.out.println("Armies's stats:");
		for (Army army : armyList) {
			army.checkCastleBoost(this);
			army.checkHeroBoost(this);
			System.out.println("Army type : " + army.getArmyType());
			System.out.println("Attack boost : " + army.getBoostAttack());
			System.out.println("Skill boost : " + army.getBoostSkill());
			System.out.println("Amount : " + army.getArmyAmount());
		}
	}

	public void viewStatsCastle() {
		System.out.println("Castle's stats:");
		System.out.println("Current Castle Skin: " + currentCastle.getSkinCastle());
		System.out.println("Boosting "+ currentCastle.getBoostArmy() +" for " + currentCastle.getBoostAmount() +"%");
	}

	public void viewStatsHero() {
		System.out.println("Hero(s)'s stats:");
		for (Hero hero : heroList) {
			System.out.println("Hero type : "+ hero.getHeroType());
			System.out.println("Level : "+ hero.getLevelHero());
			System.out.println("Boosting "+ hero.getArmyType() +" for " + hero.getBoostAmount());
		}
	}

	public Castle getCurrentCastle() {
		return currentCastle;
	}
	public Vector<Army> getArmyList() {
		return armyList;
	}
	public Vector<Hero> getHeroList() {
		return heroList;
	}

	public Integer getPlayerNumber() {
		return playerNumber;
	}

}
