package droids;

import HelperClasses.TextMessages;

public class Rabbit extends Droid{
    private final int maxHp = 50;
    private final int maxDamage = 8;
    private final int maxUsageOfSA = 3;
    private final String[] defaultSkin = {  "(\\ /)  ",
                                            "( . .) ",
                                            "с(\")(\")"};
    private final String[] damageSkin = {"(\\ /)  ",
                                         "(>.<)  ",
                                         "с(\")(\")"};

    private final String[] deathSkin = {"(\\ /)  ",
                                        "( X X)  ",
                                        "c(\")(\")"};

    private final String specialAbilitySkin =
            TextMessages.GREENHighIntensity + "  \\/_\n" +
            " _/\n" +
            TextMessages.YELLOWHighIntensity + "(,;)\n" +
            "(,.)\n" +
            "(,/\n" +
            "|/\n" + TextMessages.RESET;

    public Rabbit(String name){
        super("Rabbit",name, 50, 8);
    }

    public String[] getDefaultSkin(){return this.defaultSkin;}
    public String[] getDamageSkin(){ return this.damageSkin; }
    public String[] getDeathSkin(){ return this.deathSkin; }
    public String getSpecialAbilitySkin() {return this.specialAbilitySkin;}

    @Override
    public void resetDroid(Droid d){
        d.setHp(maxHp);
        d.setDamage(maxDamage);
        d.setUsingAmountOfSA(maxUsageOfSA);
    }

    public int getMaxHp(){return maxHp;}

    public void specialAbility(Droid droid) {
        int hp = droid.getHp();
        droid.setHp(hp + hp / 5);
        System.out.println(getName() + " ate some carrot!");
    }

}

