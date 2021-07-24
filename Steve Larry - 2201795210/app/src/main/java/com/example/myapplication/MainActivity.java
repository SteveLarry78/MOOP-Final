package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Vector;
import com.example.myapplication.ArmyTypes.*;
import com.example.myapplication.HeroTypes.*;

public class MainActivity extends AppCompatActivity {


    public TextView p1Info;
    public TextView p2Info;
    public TextView announce;
    public Button buttonBattle;
    public static Vector<Player> playerList = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doDefault1(View view){
        p1Info = (TextView)findViewById(R.id.P1army);
        p2Info = (TextView)findViewById(R.id.P2army);
        announce = (TextView)findViewById(R.id.announce);
        buttonBattle = (Button)findViewById(R.id.button);
        p1Info.setText("-");
        p2Info.setText("-");
        announce.setText("-");
        playerList.clear();
        playerList.add(new Player(1));
        playerList.add(new Player(2));
        buttonBattle.setVisibility(View.VISIBLE);
        defaultStats1();
        String tempArmy = "";
        for(Army army : playerList.get(0).getArmyList()){
            tempArmy += army.getArmyType() + " " + army.getArmyAmount()+"\n";
        }
        String tempHero = "";
        for(Hero hero : playerList.get(0).getHeroList()){
            tempHero += hero.getHeroType() +", ";
        }
        p1Info.setText("Army : "+tempArmy+"Hero : "+tempHero);

        tempArmy = "";
        for(Army army : playerList.get(1).getArmyList()){
            tempArmy += army.getArmyType() + " " + army.getArmyAmount()+"\n";
        }
        tempHero = "";
        for(Hero hero : playerList.get(1).getHeroList()){
            tempHero += hero.getHeroType() +", ";
        }
        p2Info.setText("Army : "+tempArmy+"Hero : "+tempHero);
    }

    public void doDefault2(View view){
        p1Info = (TextView)findViewById(R.id.P1army);
        p2Info = (TextView)findViewById(R.id.P2army);
        announce = (TextView)findViewById(R.id.announce);
        buttonBattle = (Button)findViewById(R.id.button);
        p1Info.setText("-");
        p2Info.setText("-");
        announce.setText("-");
        playerList.clear();
        playerList.add(new Player(1));
        playerList.add(new Player(2));
        buttonBattle.setVisibility(View.VISIBLE);
        defaultStats2();
        String tempArmy = "";
        for(Army army : playerList.get(0).getArmyList()){
            tempArmy += army.getArmyType() + " " + army.getArmyAmount()+"\n";
        }
        String tempHero = "";
        for(Hero hero : playerList.get(0).getHeroList()){
            tempHero += hero.getHeroType() +", ";
        }
        p1Info.setText("Army : "+tempArmy+"Hero : "+tempHero);

        tempArmy = "";
        for(Army army : playerList.get(1).getArmyList()){
            tempArmy += army.getArmyType() + " " + army.getArmyAmount()+"\n";
        }
        tempHero = "";
        for(Hero hero : playerList.get(1).getHeroList()){
            tempHero += hero.getHeroType() +", ";
        }
        p2Info.setText("Army : "+tempArmy+"Hero : "+tempHero);
    }

    public void defaultStats1() {
        //player 1 Cavalry only
        playerList.get(0).castleChangeSkin("Horse");
        playerList.get(0).addArmy("Cavalry");
        playerList.get(0).setArmyAmount("Cavalry",100000);
        playerList.get(0).addHero("Cavalry");
        playerList.get(0).addHero("Cavalry");
        playerList.get(0).addHero("Cavalry");
        playerList.get(0).addHero("Cavalry");
        playerList.get(0).addHero("Cavalry");
        //player 2 Archer only
        playerList.get(1).castleChangeSkin("Wood");
        playerList.get(1).addArmy("Archer");
        playerList.get(1).setArmyAmount("Archer",100000);
        playerList.get(1).addHero("Archer");
        playerList.get(1).addHero("Archer");
        playerList.get(1).addHero("Archer");
        playerList.get(1).addHero("Archer");
        playerList.get(1).addHero("Archer");
    }

    public void defaultStats2() {
        //player 1 Cavalry only
        playerList.get(0).castleChangeSkin("Horse");
        playerList.get(0).addArmy("Cavalry");
        playerList.get(0).addArmy("Archer");
        playerList.get(0).addArmy("Infantry");
        playerList.get(0).setArmyAmount("Cavalry",35000);
        playerList.get(0).setArmyAmount("Archer",40000);
        playerList.get(0).setArmyAmount("Infantry",25000);
        playerList.get(0).addHero("Archer");
        playerList.get(0).addHero("Cavalry");
        playerList.get(0).addHero("Cavalry");
        playerList.get(0).addHero("Infantry");
        playerList.get(0).addHero("Infantry");
        //player 2 Archer only
        playerList.get(1).castleChangeSkin("Steel");
        playerList.get(1).addArmy("Infantry");
        playerList.get(1).setArmyAmount("Infantry",100000);
        playerList.get(1).addHero("Infantry");
        playerList.get(1).addHero("Infantry");
        playerList.get(1).addHero("Infantry");
        playerList.get(1).addHero("Infantry");
        playerList.get(1).addHero("Infantry");
    }




    public void doBattle(View view) {
        //0 Archer 1 Catapult 2 Cavalry 3 Infantry
        int[] p1Power = playerList.get(0).armyPower();
        int[] p2Power = playerList.get(1).armyPower();

        int deadP1Archer, deadP1Catapult, deadP1Cavalry, deadP1Infantry, deadP2Archer, deadP2Catapult, deadP2Cavalry, deadP2Infantry;
        int totalP1Death, totalP2Death, totalP1Alive, totalP2Alive;
        totalP1Alive = totalP2Alive = totalP1Death = totalP2Death = 0;
        deadP1Archer = (int) (p2Power[3]*0.4 + p2Power[2]*0.1);
        deadP1Catapult = 0;
        deadP1Cavalry = (int) (p2Power[0]*0.4 + p2Power[3]*0.1);
        deadP1Infantry = (int) (p2Power[2]*0.4 + p2Power[0]*0.1);


        deadP2Archer = (int) (p1Power[3]*0.4 + p1Power[2]*0.1);
        deadP2Catapult = 0;
        deadP2Cavalry = (int) (p1Power[0]*0.4 + p1Power[3]*0.1);
        deadP2Infantry = (int) (p1Power[2]*0.4 + p1Power[0]*0.1);

        for(Army army : playerList.get(0).getArmyList()){
            if(army.getArmyType().equalsIgnoreCase("Archer")){
                if(army.getArmyAmount()-deadP1Archer <= 0){
                    totalP1Death += army.getArmyAmount();
                }else{
                    totalP1Death += deadP1Archer;
                    totalP1Alive += army.getArmyAmount()-deadP1Archer;
                }
            }else if(army.getArmyType().equalsIgnoreCase("Catapult")){
                if(army.getArmyAmount()-deadP1Catapult <= 0){
                    totalP1Death += army.getArmyAmount();
                }else{
                    totalP1Death += deadP1Catapult;
                    totalP1Alive += army.getArmyAmount()-deadP1Catapult;
                }
            }else if(army.getArmyType().equalsIgnoreCase("Cavalry")){
                if(army.getArmyAmount()-deadP1Cavalry <= 0){
                    totalP1Death += army.getArmyAmount();
                }else{
                    totalP1Death += deadP1Cavalry;
                    totalP1Alive += army.getArmyAmount()-deadP1Cavalry;
                }
            }else if(army.getArmyType().equalsIgnoreCase("Infantry")){
                if(army.getArmyAmount()-deadP1Infantry <= 0){
                    totalP1Death += army.getArmyAmount();
                }else{
                    totalP1Death += deadP1Infantry;
                    totalP1Alive += army.getArmyAmount()-deadP1Infantry;
                }
            }
        }

        for(Army army : playerList.get(1).getArmyList()){
            if(army.getArmyType().equalsIgnoreCase("Archer")){
                if(army.getArmyAmount()-deadP1Archer <= 0){
                    totalP2Death += army.getArmyAmount();
                }else{
                    totalP2Death += deadP2Archer;
                    totalP2Alive += army.getArmyAmount()-deadP2Archer;
                }
            }else if(army.getArmyType().equalsIgnoreCase("Catapult")){
                if(army.getArmyAmount()-deadP1Catapult <= 0){
                    totalP2Death += army.getArmyAmount();
                }else{
                    totalP2Death += deadP2Catapult;
                    totalP2Alive += army.getArmyAmount()-deadP2Catapult;
                }
            }else if(army.getArmyType().equalsIgnoreCase("Cavalry")){
                if(army.getArmyAmount()-deadP1Cavalry <= 0){
                    totalP2Death += army.getArmyAmount();
                }else{
                    totalP2Death += deadP2Cavalry;
                    totalP2Alive += army.getArmyAmount()-deadP2Cavalry;
                }
            }else if(army.getArmyType().equalsIgnoreCase("Infantry")){
                if(army.getArmyAmount()-deadP1Infantry <= 0){
                    totalP2Death += army.getArmyAmount();
                }else{
                    totalP2Death += deadP2Infantry;
                    totalP2Alive += army.getArmyAmount()-deadP2Infantry;
                }
            }
        }

        announce = (TextView)findViewById(R.id.announce);
        if(totalP1Death < totalP2Death){
            announce.setText("WON : Player 1 with "+totalP1Death+" dead armies, and "+totalP1Alive+" survives\nLOST: Player 2 with "+totalP2Death+" dead armies, and "+totalP2Alive+" survives");
        }else if(totalP1Death > totalP2Death){
            announce.setText("WON : Player 2 with "+totalP2Death+" dead armies, and "+totalP2Alive+" survives\nLOST: Player 1 with "+totalP1Death+" dead armies, and "+totalP1Alive+" survives");
        }else if(totalP1Death == totalP2Death){
            announce.setText("DRAW : with "+totalP1Death+"dead armies");
        }

    }

    public void resetView(View view){
        p1Info = (TextView)findViewById(R.id.P1army);
        p2Info = (TextView)findViewById(R.id.P2army);
        announce = (TextView)findViewById(R.id.announce);
        buttonBattle = (Button)findViewById(R.id.button);
        p1Info.setText("-");
        p2Info.setText("-");
        announce.setText("-");
        buttonBattle.setVisibility(View.INVISIBLE);
        playerList.clear();
    }
}