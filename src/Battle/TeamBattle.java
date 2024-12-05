package Battle;

import HelperClasses.TextMessages;
import droids.Droid;
import droids.SpecialDroid;
import droids.Team;

import java.util.ArrayList;
import java.util.Random;

public class TeamBattle {
    private static final TextMessages output = new TextMessages();
//    private static Team team1;
//    private static Team team2;
    private Team team1;
    private Team team2;



    public TeamBattle(Team team1, Team team2){
//        this.team1 = (Team) team1;
//        this.team2 = (Team) team2;
        this.team1 = team1;
        this.team2 = team2;

    }

    public void fight(){
        output.startForTeamBattle(team1, team2);
        int round = 0;
//        Team teamA = (Team) team1;

        while(team1.isSomeoneAlive() && team2.isSomeoneAlive()){
            round++;
            System.out.println("\n=*=*=*= Round" + round + "=*=*=*=\n");
            for(int i = 0; i < team1.size() && i < team2.size(); i++){
                Droid a = team1.choosingRandomDroid();
                Droid b = team2.choosingRandomDroid();
                while (a.isAlive() && b.isAlive()){
                    output.displayHealth(a, b);

                    Random r = new Random();
                    if (r.nextBoolean()){
                        if (!team1.isSomeoneAlive()){
                            break;
                        }
                        battleProcess(a, b);
                    }else {
                        if (!team2.isSomeoneAlive()){
                            break;
                        }
                        battleProcess(b, a);
                    }

                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }
        output.resultOfTeamBattle(team1, team2);
    }

//    private Droid choosingRandomDroid(ArrayList<Droid> team){
//        Random r = new Random();
//        int index = r.nextInt(team.size());
//        Droid droid = team.get(index);
//        while (!droid.isAlive()){
//            index = r.nextInt(team.size());
//            droid = team.get(index);
//            if (!isSomeoneAlive(team)){
//                break;
//            }
//        }
//        return droid;
//    }

    public void battleProcess(Droid attacker, Droid defender) {
        Random random = new Random();
        if (random.nextBoolean()) {
            takeDamage(attacker, defender);
        } else {
           useSpecialAbility(attacker, defender);
        }
    }

    private void useSpecialAbility(Droid attacker, Droid defender){
        int amountOfUseSA = attacker.getUsingAmountOfSA();
        if (amountOfUseSA > 0) {
            attacker.setUsingAmountOfSA(amountOfUseSA - 1);
            if (attacker.canSummon()){
                Droid specialDroid = new SpecialDroid("PES PATRON", 1000, 1000);
                output.printDefaultSkin(specialDroid);
                takeDamage(specialDroid, defender);
            }else {
                attacker.specialAbility();
                output.printSpecialAbilitySkin(attacker);
            }
        }
        else {
            takeDamage(attacker, defender);
        }
    }

    private void takeDamage(Droid attacker, Droid defender){
        int hp = defender.getHp();
        defender.setHp(hp - attacker.getDamage());
        if ((hp - defender.getDamage()) < 0){
            defender.setHp(0);
        }
        output.printSkin(defender);
    }

    public static boolean isSomeoneAlive(ArrayList<Droid> team){
        int numOfAlive = 0;
        for (Droid droid : team){
            if(droid.isAlive()){
                numOfAlive++;
            }
        }
        return numOfAlive > 0;
    }
}
