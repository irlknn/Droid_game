package Battle;

import HelperClasses.TextMessages;
import droids.Droid;
import droids.Team;

import java.util.ArrayList;

public class PVPBattle extends TeamBattle {
    private static final TextMessages output = new TextMessages();
    Droid droidA;
    Droid droidB;

    public PVPBattle(Team team1, int index1 , Team team2, int index2) {
        super(team1, team2);
        droidA = team1.get(index1);
        droidB = team2.get(index2);
    }

    public void fight() {
        output.startForPvpBattle(droidA, droidB);
        while (droidA.isAlive() && droidB.isAlive()) {
            if(droidA.isAlive())
                battleProcess(droidA, droidB);
            else break;

            if(droidB.isAlive())
                battleProcess(droidB, droidA);
            else break;

            output.displayHealth(droidA, droidB);
            System.out.println(droidA);
            System.out.println(droidB);
        }
        output.resultOfPvpBattle(droidA, droidB);
    }
}
