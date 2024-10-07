package HelperClasses;

import Battle.TeamBattle;
import droids.Cow;
import droids.Droid;
import droids.Owl;
import droids.Rabbit;

import java.util.ArrayList;

public class TextMessages {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";

    public static final String YELLOWHighIntensity = "\u001B[1;93m";
    public static final String GREENHighIntensity = "\u001B[1;92m";

    public static final String BLUEHighIntensity = "\u001B[1;94m";
    public static final String REDHighIntensity = "\u001B[1;91m";

    public void printTitle(){
        System.out.println("""
                ______   ______  _____  _____ ______        ______ _______ _______ _______
                |     \\ |_____/ |     |   |   |     \\      |  ____ |_____| |  |  | |______
                |_____/ |    \\_ |_____| __|__ |_____/      |_____| |     | |  |  | |______
                """);
    }

    public void showMenu() {
        System.out.println("\n" + YELLOW +
                           "~-~-~-~- MENU -~-~-~-~\n"  +
                           RESET +
                           "1. Create Droid\n" +
                           "2. Show droid list\n" +
                           "3. Droid vs droid\n" +
                           "4. Team vs Team\n" +
                           "5. Download game to file\n" +
                           "6. Upload game out of file\n" +
                           "7. Download already created droid\n" +
                           "0. Exit\n" +
                           YELLOW +
                           "~-~-~-~-~-~-~-~-~-~-~" + RESET);
    }

    public void showDroidList(ArrayList<Droid> droids) {
        if (droids.isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.println(BLUE + "___  ____ ____ _ ___  ____     \n" +
                               "|  \\ |__/ |  | | |  \\ [__     .\n" +
                               "|__/ |  \\ |__| | |__/ ___]    ." + RESET);
            for (int i = 0; i < droids.size(); i++) {
                System.out.println((i + 1) + ". " + droids.get(i));
            }
        }
    }

    public void printAllDroidType() {
        System.out.println("1. Rabbit");
        printDefaultSkin(new Rabbit(" "));
        System.out.println("2. Cow");
        printDefaultSkin(new Cow(" "));
        System.out.println("3. Owl");
        printDefaultSkin(new Owl(" "));
    }

    public void startForTeamBattle(ArrayList<Droid> team1, ArrayList<Droid> team2) {
        System.out.println("""
                
                __| |______________________________________________________| |__
                __   ______________________________________________________   __
                  | |                                                      | | \s
                  | |  ____ ____ _  _ ____    ____ ___ ____ ____ ___ ____  | | \s
                  | |  | __ |__| |\\/| |___    [__   |  |__| |__/  |  [__   | | \s
                  | |  |__] |  | |  | |___    ___]  |  |  | |  \\  |  ___]  | | \s
                __| |______________________________________________________| |__
                __   ______________________________________________________   __
                  | |                                                      | | \s""");
        System.out.println("**** Team 1 ****\n");
        showDroidList(team1);
        System.out.println("**** Team 2 ****\n");
        showDroidList(team2);
    }

    public void startForPvpBattle(Droid a, Droid b){
        System.out.println("""
                __| |______________________________________________________| |__
                __   ______________________________________________________   __
                  | |                                                      | | \s
                  | |  ____ ____ _  _ ____    ____ ___ ____ ____ ___ ____  | | \s
                  | |  | __ |__| |\\/| |___    [__   |  |__| |__/  |  [__   | | \s
                  | |  |__] |  | |  | |___    ___]  |  |  | |  \\  |  ___]  | | \s
                __| |______________________________________________________| |__
                __   ______________________________________________________   __
                  | |                                                      | | \s""");

        displayHealth(a, b);
    }

    public void resultOfTeamBattle(ArrayList<Droid> team1, ArrayList<Droid> team2) {
        if (TeamBattle.isSomeoneAlive(team1)){
            System.out.println("Team 1 WIN");
        for (Droid d : team1){
            System.out.println(d.getName());
            printDefaultSkin(d);
        }
    }
        else if (TeamBattle.isSomeoneAlive(team2)){
            System.out.println("Team 2 WIN");
            for (Droid d : team2){
                System.out.println(d.getName());
                printDefaultSkin(d);
            }
        }
        else System.out.println(" There is some bug ");

        System.out.println("""
                ____ _  _ ___     ____ ____    ___ _  _ ____    ____ ____ _  _ ____
                |___ |\\ | |  \\    |  | |___     |  |__| |___    | __ |__| |\\/| |___
                |___ | \\| |__/    |__| |        |  |  | |___    |__] |  | |  | |___""");
    }

    public void resultOfPvpBattle(Droid a, Droid b){
        if(a.isAlive()){
            System.out.println("_ _ _ _ _  _ _  _ ____ ____  \n" +
                               "| | | | |\\ | |\\ | |___ |__/ .\n" +
                               "|_|_| | | \\| | \\| |___ |  \\ . " + a.getName());
            printDefaultSkin(a);
            printDeathSkin(b);
        }else if(b.isAlive()){
            System.out.println("_ _ _ _ _  _ _  _ ____ ____  \n" +
                               "| | | | |\\ | |\\ | |___ |__/ .\n" +
                               "|_|_| | | \\| | \\| |___ |  \\ . " + b.getName());
            printDefaultSkin(b);
            printDeathSkin(a);
        }else{
            System.out.println("... This time nobody wins ...");
            printDeathSkin(a);
            printDeathSkin(b);
        }
        System.out.println("""
                ____ _  _ ___     ____ ____    ___ _  _ ____    ____ ____ _  _ ____
                |___ |\\ | |  \\    |  | |___     |  |__| |___    | __ |__| |\\/| |___
                |___ | \\| |__/    |__| |        |  |  | |___    |__] |  | |  | |___""");
    }

    public void printSkin(Droid d) {
        if (d.isAlive())
            printDamageSkin(d);
        else {
            printDeathSkin(d);
        }
    }

    public void printDefaultSkin(Droid droid) {
        String[] skin = droid.getDefaultSkin();
        for (String s : skin)
            System.out.println(s);
    }

    private void printDamageSkin(Droid d) {
        String[] skin = d.getDamageSkin();
        System.out.println(d.getName() + " was hit");
        for (String s : skin)
            System.out.println(s);
    }

    private void printDeathSkin(Droid d) {
        String[] skin = d.getDeathSkin();
        System.out.println(d.getName() + " was killed");
        for (String s : skin)
            System.out.println(s);
    }

    public void printSpecialAbilitySkin(Droid d){
        String skin = d.getSpecialAbilitySkin();
        System.out.println(skin);
    }

    public void exitText(){
        System.out.println(YELLOW + " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                           "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                           " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                           " /\\_/\\                                                   /\\_/\\ \n" +
                           "( o.o )    " + RESET + "___  _   _ ____    ___  _   _ ____      /" + YELLOW + "    ( o.o )\n" +
                           " > ^ <     " + RESET + "|__]  \\_/  |___    |__]  \\_/  |___     /" + YELLOW + "      > ^ < \n" +
                           " /\\_/\\     " + RESET + "|__]   |   |___    |__]   |   |___    ." + YELLOW + "       /\\_/\\ \n" +
                           "( o.o )                                                 ( o.o )\n" +
                           " > ^ <                                                   > ^ < \n" +
                           " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                           "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                           " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < " + RESET);
    }

    public void displayHealth(Droid a, Droid b) {
        System.out.println("\n==================================");
        System.out.println(a.getName() + " " + healthBar(a));
        System.out.println("    vs");
        System.out.println(b.getName() + " " + healthBar(b));
        System.out.println("==================================\n");
    }

    private String healthBar(Droid droid) {
        int totalBars = droid.getMaxHp() / 2;
        int filledBars = (int) (droid.getHp() / 2.0);
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < totalBars; i++) {
            if (i < filledBars) {
                bar.append(RED + "=" + RESET);
            } else {
                bar.append(" ");
            }
        }
        bar.append("] ");
        bar.append(droid.getHp()).append(" HP");
        return bar.toString();
    }

}
