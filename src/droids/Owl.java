package droids;

import java.util.Random;

public class Owl extends Droid {
    private final int maxHp = 40;
    private final int maxDamage = 10;
    private final int maxUsageOfSA = 3;
    private final String[] defaultSkin = {".___.",
                            "{o,o}",
                            "/)__)",
                            "-\"-\"-"};
    private final String[] damageSkin = { ".___.",
                                    "{>,<}",
                                    "/)__)",
                                    "-\"-\"-"};

    private final String[] deathSkin = {  "^___^",
                                    "{X,X}",
                                    "/)__)",
                                    "-\"-\"-"};

    private final String specialAbilitySkin = """
                 .              .   .'.     \\   /
               \\   /      .'. .' '.'   '  -=  o  =-
             -=  o  =-  .'   '              / | \\
               / | \\                          |
                 |                            |
                 |                            |
                 |                      .=====|
                 |=====.                |.---.|
                 |.---.|                ||=o=||
                 ||=o=||                ||   ||
                 ||   ||                ||   ||
                 ||   ||                ||___||
                 ||___||                |[:::]|
                 |[:::]|                '-----'
                 '-----'
            """;

    public Owl(String name){
        super("Owl", name, 40, 10);
    }

    public String[] getDefaultSkin(){ return this.defaultSkin; }
    public String[] getDamageSkin(){ return this.damageSkin; }
    public String[] getDeathSkin(){ return this.deathSkin; }
    public String getSpecialAbilitySkin() { return this.specialAbilitySkin; }

    @Override
    public void resetDroid(){
        setHp(maxHp);
        setDamage(maxDamage);
        setUsingAmountOfSA(maxUsageOfSA);
    }

    public int getMaxHp(){return maxHp;}

    public boolean canSummon(){
        Random random = new Random();
        System.out.println("Owl trying to find some help");
        if (random.nextInt(100) < 20) {
            System.out.println("WHAT THE HELL");
            return true;
        }else{
            System.out.println("Nobody have helped");
            return false;
        }
    }
}
