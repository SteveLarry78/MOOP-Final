package com.example.myapplication;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	private Scanner scan = new Scanner(System.in);
	public static Vector<Player> playerList = new Vector<>();
	
	public void defaultStats() {
		//player 1
		playerList.get(0).castleChangeSkin("Steel");
		playerList.get(0).addArmy("Infantry");
		playerList.get(0).addArmy("Archer");
		playerList.get(0).addArmy("Catapult");
		playerList.get(0).addArmy("Cavalry");
		playerList.get(0).addHero("Infantry");
		playerList.get(0).addHero("Infantry");
		playerList.get(0).addHero("Infantry");
		playerList.get(0).addHero("Catapult");
		playerList.get(0).addHero("Cavalry");
		playerList.get(0).addHero("Archer");
		//player 2
		playerList.get(1).castleChangeSkin("Stone");
		playerList.get(1).addArmy("Infantry");
		playerList.get(1).addArmy("Archer");
		playerList.get(1).addArmy("Catapult");
		playerList.get(1).addArmy("Cavalry");
		playerList.get(1).addHero("Catapult");
		playerList.get(1).addHero("Catapult");
		playerList.get(1).addHero("Catapult");
		playerList.get(1).addHero("Cavalry");
		playerList.get(1).addHero("Archer");
		playerList.get(1).addHero("Infantry");
		//player 3
		playerList.get(2).castleChangeSkin("Wood");
		playerList.get(2).addArmy("Infantry");
		playerList.get(2).addArmy("Archer");
		playerList.get(2).addArmy("Catapult");
		playerList.get(2).addArmy("Cavalry");
		playerList.get(2).addHero("Archer");
		playerList.get(2).addHero("Archer");
		playerList.get(2).addHero("Archer");
		playerList.get(2).addHero("Cavalry");
		playerList.get(2).addHero("Catapult");
		playerList.get(2).addHero("Infantry");
		//player 4
		playerList.get(3).castleChangeSkin("Horse");
		playerList.get(3).addArmy("Infantry");
		playerList.get(3).addArmy("Archer");
		playerList.get(3).addArmy("Catapult");
		playerList.get(3).addArmy("Cavalry");
		playerList.get(3).addHero("Cavalry");
		playerList.get(3).addHero("Cavalry");
		playerList.get(3).addHero("Cavalry");
		playerList.get(3).addHero("Catapult");
		playerList.get(3).addHero("Infantry");
		playerList.get(3).addHero("Archer");
	}
	
	public Main() {
		playerList.add(new Player(1));
		playerList.add(new Player(2));
		playerList.add(new Player(3));
		playerList.add(new Player(4));
		
		//Comment line below for inputted player, don't comment for manual input
		defaultStats();
		
		int inputCom = 0;
		int selectedPlayer = 0;
	do {
		clrScr();
		inputCom = selectedPlayer = 0;
		System.out.println("Roll Playing Game");
		System.out.println("-----------------");
		System.out.println("1. Change castle's skin");
		System.out.println("2. Add army");
		System.out.println("3. Add hero");
		System.out.println("4. View players stats");
		System.out.println("5. Exit");
		System.out.println("-----------------");
		do {
			System.out.print("Input Command Number(1-5):");
			inputCom = scan.nextInt();
			scan.nextLine();
		}while(inputCom < 1 || inputCom > 5);
		
		if(inputCom != 5 ) {
			do {
				System.out.print("Input player number to be selected (1-" + playerList.size()+") :");
				selectedPlayer = scan.nextInt();
				scan.nextLine();
			}while(selectedPlayer < 1 || selectedPlayer > playerList.size());
		}
		clrScr();
		switch (inputCom) {
			case 1:
				castleChange(selectedPlayer);
				scan.nextLine();
				break;
			case 2:
				addArmy(selectedPlayer);
				scan.nextLine();
				break;
			case 3:
				addHero(selectedPlayer);
				scan.nextLine();
				break;
			case 4:
				playerList.get(selectedPlayer-1).viewStats();
				scan.nextLine();
				break;
		
		}
	}while(inputCom != 5);		
	}
	
	public void castleChange(int player) {
		String skin;
		do {
			System.out.print("Pick new castle skin (Horse, Steel, Stone, Wood)\n->");
			skin = scan.nextLine();
		}while(!skin.equalsIgnoreCase("Horse") && !skin.equalsIgnoreCase("Steel") && !skin.equalsIgnoreCase("Stone") && !skin.equalsIgnoreCase("Wood"));
		playerList.get(player-1).castleChangeSkin(skin);
	}
	
	public void addArmy(int player) {
		String army;
		do {
			System.out.print("Pick new army to be added (Archer, Catapult, Cavalry, Infantry)\n->");
			army = scan.nextLine();
		}while(!army.equalsIgnoreCase("Archer") && !army.equalsIgnoreCase("Catapult") && !army.equalsIgnoreCase("Cavalry") && !army.equalsIgnoreCase("Infantry"));
		playerList.get(player-1).addArmy(army);
	}
	
	public void addHero(int player) {
		String hero;
		do {
			System.out.print("Pick new hero to be added (Archer, Catapult, Cavalry, Infantry)\n->");
			hero = scan.nextLine();
		}while(!hero.equalsIgnoreCase("Archer") && !hero.equalsIgnoreCase("Catapult") && !hero.equalsIgnoreCase("Cavalry") && !hero.equalsIgnoreCase("Infantry"));
		playerList.get(player-1).addHero(hero);
	}
	
	public void clrScr() {
		for(int i = 0 ; i < 50 ; i++) {
			System.out.println("");
		}
	}

	
}
