package Battle;

import HelperClasses.TextMessages;
import droids.Droid;

import java.util.ArrayList;

public class PVPBattle extends TeamBattle {
    private static final TextMessages output = new TextMessages();
    Droid droidA;
    Droid droidB;

    public PVPBattle(ArrayList<Droid> team1, int index1 ,ArrayList<Droid> team2, int index2) {
        super(team1, team2);
        droidA = team1.get(index1);
        droidB = team2.get(index2);
    }

    public void fight() {
        output.startForPvpBattle(droidA, droidB);

        while (droidA.isAlive() && droidB.isAlive()) {
            battleProcess(droidA, droidB);
            battleProcess(droidB, droidA);

            output.displayHealth(droidA, droidB);
            System.out.println(droidA);
            System.out.println(droidB);
        }
        output.resultOfPvpBattle(droidA, droidB);
    }
}

    //        else if (isSimple(number)) {
//            System.out.println("AAAAAAAAAAAAAAAAAAAA");
//        }

//    private boolean isSimple(int number) {
//        if (number < 2)
//            return false;
//        double s = sqrt(number);
//        for (int i = 2; i <= s; i++) {
//            if (number % i == 0)
//                return false;
//        }
//        return true;
//    }



