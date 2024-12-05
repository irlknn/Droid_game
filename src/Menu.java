import Battle.PVPBattle;
import Battle.TeamBattle;
import HelperClasses.TextMessages;
import droids.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final Team droids = new Team();// = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);
    private static final TextMessages output = new TextMessages();
    private static final FileWork fileWork = new FileWork();

    public static void start(){
        output.printTitle();
        while(true){
            output.showMenu();
            int choice = input.nextInt();
            switch (choice){
                case 1: createDroid(); break;
                case 2: loadAlreadyCreatedDroids(); break;
                case 3: output.showDroidList(droids); break;
                case 4: pvpFight(false); resetEveryDroid(); break;
                case 5: teamFight(false); resetEveryDroid(); break;
                case 6: chooseTypeOfBattleToRecord(); fileWork.stopLogging(); break;
                case 7: fileWork.upload(); break;
                case 0: output.exitText(); return;
            }
        }
    }

    public static void createDroid(){
        Droid droid = null;
        System.out.println("Enter name for your droid: ");
        String name = input.next();

        output.printAllDroidType();
        System.out.println("Choose type of droid (1-3):\n");
        int droidTypeIndex = input.nextInt();

        while(doesSameDroidExist(name, droidTypeIndex)){
            System.out.println("This droid already exist!");
            System.out.println("Enter name for your droid: ");
            name = input.next();

            output.printAllDroidType();
            droidTypeIndex = input.nextInt();
        }

        switch (droidTypeIndex){
            case 1: droid = new Rabbit(name); break;
            case 2: droid = new Cow(name); break;
            case 3: droid = new Owl(name); break;
            default: System.out.println("enter number between 1 and 3");
            break;
        }

        droids.add(droid);
        System.out.println(droid);
    }

    private static boolean doesSameDroidExist(String name, int droidTypeIndex){
        String droidType;
        switch (droidTypeIndex){
            case 1: droidType = "Rabbit"; break;
            case 2: droidType = "Cow"; break;
            case 3: droidType = "Owl"; break;
            default: System.out.println("Be careful! Enter number between 1 and 3");
                return true;
        }
        for (Droid droid : droids){
            if(droid.getName().equals(name) && droid.getDroidType().equals(droidType))
                return true;
        }
        return false;
    }

    private static void loadAlreadyCreatedDroids(){
        droids.add(new Rabbit("nadia"));
        droids.add(new Cow("vasil"));
        droids.add(new Owl("Yurii"));
        droids.add(new Owl("Dana"));
        droids.add(new Rabbit("rabbit"));
        droids.add(new Cow("cow"));
        droids.add(new Owl("Owl"));
        droids.add(new Cow("cat"));
        droids.add(new Cow("luna"));
        droids.add(new Rabbit("daisy"));
        System.out.println(droids.size() + " new droid have been created");
    }

    public static void pvpFight(boolean recordToFile){
        if(isDroidsSizeLessThan(2)){
            System.out.println("Not enough droids for the fight");
            return;
        }

        output.showDroidList(droids);
        System.out.println("\nChoose first droid");
        int firstDroidIndex = input.nextInt() - 1;
        System.out.println("\nChoose second droid");
        int secondDroidIndex = input.nextInt() - 1;

        if(recordToFile){
            fileWork.download();
        }

        PVPBattle battle = new PVPBattle(droids, firstDroidIndex, droids, secondDroidIndex);
        battle.fight();
    }

    public static void teamFight(boolean recordToFile){
        if(isDroidsSizeLessThan(1)){
            return;
        }

        System.out.println("Enter size of teams (" + droids.size() + " - maximum size)");
        int size = input.nextInt();
        while (size <= 1 ){
            System.out.println("Try again size must be between 1 and " + droids.size());
            size = input.nextInt();
        }

        ArrayList<Droid> A = new ArrayList<>();
        ArrayList<Droid> B = new ArrayList<>();
        output.showDroidList(droids);
        System.out.println("Choose droids for Team1");
        Team team1 = new Team(A);
        fillTheTeam(size, team1);
        System.out.println("Choose droids for Team2");
        Team team2 = new Team(B);
        fillTheTeam(size, team2);

        if(recordToFile){
            fileWork.download();
        }
        TeamBattle battle = new TeamBattle(team1, team2);
        battle.fight();
    }

    private static void chooseTypeOfBattleToRecord(){
        System.out.println("""
                Select the type of battle you want to record:
                1. Droid vs droid
                2. Team vs team""");
        int choice = input.nextInt();
        if(choice == 1){
            pvpFight(true);
        }else if(choice == 2){
            teamFight(true);
        }else {
            while (choice < 0 || choice > 2){
                System.out.println("Enter 1 or 2");
                choice = input.nextInt();
            }
        }
    }

    private static void fillTheTeam(int size, ArrayList<Droid> team){
        for (int i = 0; i < size; i++){
            int droidIndex = input.nextInt() - 1;
            while (droidIndex > droids.size()){
                System.out.println("There isn`t such number");
                droidIndex = input.nextInt() - 1;
            }
            team.add(droids.get(droidIndex));
        }
    }

    private static void resetEveryDroid(){
        for(Droid d : droids){
            d.resetDroid();
        }
    }

    private static boolean isDroidsSizeLessThan(int require){
        return droids.size() <= require;
    }

    public static void main(String[] args) {
        start();
    }
}