package Battle;

import HelperClasses.TextMessages;
import droids.Droid;
import droids.SpecialDroid;

import java.util.ArrayList;
import java.util.Random;

public class TeamBattle {
    private static final TextMessages output = new TextMessages();
    private static ArrayList<Droid> team1 = new ArrayList<>();
    private static ArrayList<Droid> team2 = new ArrayList<>();

    public TeamBattle(ArrayList<Droid> team1, ArrayList<Droid> team2){
        TeamBattle.team1 = team1;
        TeamBattle.team2 = team2;
    }

    public void fight(){
        output.startForTeamBattle(team1, team2);
        int round = 0;

        while(isSomeoneAlive(team1) && isSomeoneAlive(team2)){
            round++;
            System.out.println("\n=*=*=*= Round" + round + "=*=*=*=\n");
            for(int i = 0; i < team1.size() && i < team2.size(); i++){

                Droid a = choosingRandomDroid(team1);
                Droid b = choosingRandomDroid(team2);

                while (a.isAlive() && b.isAlive()){
                    output.displayHealth(a, b);

                    Random r = new Random();
                    if (r.nextBoolean()){
                        if (!isSomeoneAlive(team1)){
                            break;
                        }
                        battleProcess(a, b);
                    }else {
                        if (!isSomeoneAlive(team2)){
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

    private Droid choosingRandomDroid(ArrayList<Droid> team){
        Random r = new Random();
        int index = r.nextInt(team.size());
        Droid droid = team.get(index);
        while (!droid.isAlive()){
            index = r.nextInt(team.size());
            droid = team.get(index);
            if (!isSomeoneAlive(team)){
                break;
            }
        }
        return droid;
    }

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
                attacker.specialAbility(attacker);
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
