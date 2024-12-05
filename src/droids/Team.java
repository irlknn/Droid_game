package droids;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team extends ArrayList<Droid> {
    ArrayList<Droid> team;

    public Team(ArrayList<Droid> team){
        this.team = team;
    }

    public Team() {}

    public Droid choosingRandomDroid(){
        Random r = new Random();
        int index = r.nextInt(team.size());
        Droid droid = team.get(index);
        while (!droid.isAlive()){
            index = r.nextInt(team.size());
            droid = team.get(index);
            if (!isSomeoneAlive()){
                break;
            }
        }
        return droid;
    }

    public boolean isSomeoneAlive(){
        int numOfAlive = 0;
        for (Droid droid : team){
            if(droid.isAlive()){
                numOfAlive++;
            }
        }
        return numOfAlive > 0;
    }

    @Override
    public List<Droid> reversed() {
        return super.reversed();
    }
}
